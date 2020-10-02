package br.com.addario.cadastroapi.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.addario.cadastroapi.model.Cidade;
import br.com.addario.cadastroapi.services.CidadeService;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class CidadeControllerTest {

	private static Cidade cidade;
	private static List<Cidade> cidades;
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CidadeService service;

	@BeforeAll
	static void setUp() {
		cidade = new Cidade(1, "Belém", "Pará");
		cidades = Arrays.asList(cidade);
	}

	@Test
	void testaConsultarCidades() throws Exception {
		given(service.consultaCidades()).willReturn(cidades);
		mvc.perform(get("/api/cidades")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[{'id': 1,'nome': 'Belém';'estado': 'Pará'}]"));
	}
	@Test
	void testaConsultarCidadesPeloNome() throws Exception {
		given(service.consultaCidadePeloNome("Belém")).willReturn(Optional.of(cidade));
		mvc.perform(get("/api/cidades/cidade/Belém"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{'id': 1,'nome': 'Belém','estado': 'Pará'}"));
	}

	@Test
	void testaConsultarCidadesPeloEstado() throws Exception {
		given(service.consultaCidadesPeloEstado("Pará")).willReturn(cidades);
		mvc.perform(get("/api/cidades/estado/Pará"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json("[{'id': 1,'nome': 'Belém','estado': 'Pará'}]"));
	}
}
