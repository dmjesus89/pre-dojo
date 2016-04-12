package br.com.diegomauricio.predojo.model;

import java.util.regex.Pattern;

/**
 * Enum responsável pelas operacões que podem ocorrer no jogo
 * 
 * @author Diego Mauricio
 *
 */
public enum TipoLinhaEnum {

	INICIAR_PARTIDA("^([\\w/]+\\s[\\w:]+) (-) (New match) ([0-9]{5,20}) (has started)"), 
	JOGADOR_ASSASSINO("^([\\w/]+\\s[\\w:]+) (-) ([\\w]+) (killed) ([\\w]+) (using) ([\\w]+)"), 
	WORLD_ASSASINO("^([\\w/]+\\s[\\w:]+) (-) (<WORLD>) (killed) ([\\w]+) (by) ([\\w]+)"), 
	FINALIZAR_PARTIDA("^([\\w/]+\\s[\\w:]+) (-) (Match) ([0-9]{5,20}) (has ended)");

	private final String regex;
	private final Pattern pattern;

	private TipoLinhaEnum(String regex) {
		this.regex = regex;
		this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * @return the regex
	 */
	public final String getRegex() {
		return regex;
	}

	/**
	 * @return the pattern
	 */
	public final Pattern getPattern() {
		return pattern;
	}

}
