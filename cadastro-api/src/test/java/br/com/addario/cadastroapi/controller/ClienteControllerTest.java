package br.com.addario.cadastroapi.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.addario.cadastroapi.model.Cliente;
import br.com.addario.cadastroapi.services.ClienteService;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteControllerTest {

	private static Cliente cliente;
	private static List<Cliente> clientes;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ClienteService service;

	@BeforeAll
	static void setUp() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = dateFormat.parse("02/04/1985");
		
		
		cliente = new Cliente(1, "José Addario", "masculino", dataNascimento, 35, "Belém");
		clientes = Arrays.asList(cliente);
	}

	@Test
	void testandoConsultarClientes() throws Exception {
		given(service.consultaClientes()).willReturn(clientes);
		mvc.perform(get("/api/clientes")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(
						"[{'id': 1,'nomeCompleto': 'José Addario','sexo': 'masculino', 'idade':35, 'dataNascimento':'02/04/1985', 'cidadeCadastro':'Belém'}]"));
	}

	@Test
	void testandoConsultarClientesPorId() throws Exception {
		given(service.consultaClientePorId(1)).willReturn(Optional.of(clientes.get(0)));
		mvc.perform(get("/api/clientes/consultaporid/1")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'id': 1,'nomeCompleto': 'José Addario';'sexo': 'masculino'}"));
	}

	@Test
	void testandoConsultarClientesPorNome() throws Exception {
		given(service.consultaClientePeloNome("José Addario")).willReturn(clientes);
		mvc.perform(get("/api/clientes/consultapornome/José Addario"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json("[{'id': 1,'nomeCompleto': 'José Addario';'sexo': 'masculino'}]"));
	}

	@Test
	void testandoRemoverClientesPorId() throws Exception {
		when(service.consultaClientePorId(1)).thenReturn(Optional.of(cliente));
		MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/api/clientes/remove/{id}", 1)).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals("OK Response Status", HttpStatus.OK.value(), status);
		verify(service).removeCliente(1);

	}
}
