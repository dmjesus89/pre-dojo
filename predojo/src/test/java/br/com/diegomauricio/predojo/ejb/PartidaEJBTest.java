package br.com.diegomauricio.predojo.ejb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.diegomauricio.predojo.dao.PartidaDAO;
import br.com.diegomauricio.predojo.model.Jogador;
import br.com.diegomauricio.predojo.model.Partida;

public class PartidaEJBTest {

	@Mock
	private transient PartidaEJB partidaEJB;

	@Mock
	private transient PartidaDAO partidaDAO;

	public PartidaEJBTest() {
		MockitoAnnotations.initMocks(this);
	}

	private transient long CD_PARTIDA;
	private transient Date DATA_INICIO;

	@Before
	public void init() {
		this.CD_PARTIDA = 1;
		this.DATA_INICIO = new Date();
	}

	/**
	 * Teste para salvar com sucesso
	 */
	@Test
	public void testSalvarLogComSucesso() {
		Set<Partida> partidas = new HashSet<Partida>();
		Partida partida = new Partida(CD_PARTIDA, DATA_INICIO);

		Mockito.when(partidaDAO.salvarPartida(partida)).thenReturn(partida);
		partidas.add(partida);

		Mockito.when(partidaEJB.salvarPartidas(partidas)).thenReturn("salvo com sucesso");

		String msgRetorno = partidaEJB.salvarPartidas(partidas);

		assertEquals("salvo com sucesso", msgRetorno);

	}

	/**
	 * Teste para salvar com erro
	 */
	@Test
	public void testSalvarLogComErro() {
		Set<Partida> partidas = new HashSet<Partida>();
		Partida partida = new Partida(CD_PARTIDA, DATA_INICIO);

		Mockito.when(partidaDAO.salvarPartida(partida)).thenReturn(partida);
		partidas.add(partida);

		Mockito.when(partidaEJB.salvarPartidas(partidas)).thenReturn(
				"não existe registro para salvar");

		String msgRetorno = partidaEJB.salvarPartidas(partidas);

		assertEquals("não existe registro para salvar", msgRetorno);

	}

	/**
	 * Teste para buscar as partidas
	 */
	@Test
	public void testBuscarPartidaComSucesso() {
		Map<Long, Partida> partidas = new HashMap<Long, Partida>();
		Partida partida = new Partida(CD_PARTIDA, DATA_INICIO);
		partida.setJogadores(new ArrayList<Jogador>());
		partida.setJogadores(Arrays.asList(new Jogador("Diego")));
		partidas.put(partida.getCdPartida(), partida);

		Mockito.when(partidaDAO.buscarPartidas()).thenReturn(partidas);

		Mockito.when(partidaEJB.buscarPartidas()).thenReturn(partidas);

		Map<Long, Partida> partidasRetorno = partidaEJB.buscarPartidas();

		assertTrue(partidasRetorno.size() == 1);

	}

}
