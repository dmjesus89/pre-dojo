package br.com.diegomauricio.predojo.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import br.com.diegomauricio.predojo.ejb.PartidaEJB;
import br.com.diegomauricio.predojo.exception.PreDojoException;
import br.com.diegomauricio.predojo.impl.PartidaImpl;
import br.com.diegomauricio.predojo.model.Partida;

/**
 * Classe Principal, executa a crição do log
 * 
 * @author Diego Mauricio
 *
 */
public class Main {

	/**
	 * Método Main executor do sistema
	 * 
	 * @param args
	 *            java
	 */
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out
					.print("Digite o nome do arquivo completo e presione enter:...... \nCaminho + Nome:");
			String caminhoArquivo = reader.readLine();
			if (caminhoArquivo.isEmpty()) {
				throw new PreDojoException("Arquivo não informado");
			} else {
				carregarArquivo(caminhoArquivo.replace("\\", "/"));
			}
			System.out.println("Sistema Finalizado");
		} catch (PreDojoException e) {
			// gravarEmLog(e.getMessage(),e);
			System.out.println("Erro: " + e.getMessage());
		} catch (Exception e) {
			// gravarEmLog(e.getMessage(),e);
			System.out.println("Erro inesperado");
		}
	}

	/**
	 * Método responsável por realizar a leitura do arquivo
	 * 
	 * @param caminhoArquivo
	 *            caminho do arquivo de log
	 * @throws IOException
	 *             caso aconteça erro na leitura do arquivo
	 */
	public static void carregarArquivo(String caminhoArquivo) throws IOException {
		File logFile = new File(caminhoArquivo);

		if (!logFile.exists())
			throw new PreDojoException("Arquivo não encontrado: " + caminhoArquivo);

		if (logFile.isFile()) {
			System.out.println("Lendo arquivo: " + caminhoArquivo);

			Set<Partida> partidasRealizadas = new PartidaImpl().processarLog(logFile);
			new PartidaEJB().salvarPartidas(partidasRealizadas);
			new PartidaEJB().buscarPartidas();

		} else {
			throw new PreDojoException("Arquivo inválido: " + caminhoArquivo);
		}
	}

}
