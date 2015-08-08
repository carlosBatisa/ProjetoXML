package entity;

public class Filme {
	
	private Integer idFilme;
	private String nomeFilme;
	private String genero;
	private String classificacaoEtaria;
	private Boolean exibicao3D;
	private Integer duracao;
	
	public Filme(Integer idFilme, String nomeFilme, String genero,
			String classificacaEtaria, Boolean exibicao3d, Integer duracao) {
		super();
		this.idFilme = idFilme;
		this.nomeFilme = nomeFilme;
		this.genero = genero;
		this.classificacaoEtaria = classificacaEtaria;
		exibicao3D = exibicao3d;
		this.duracao = duracao;
	}
	public Filme() {
		super();
	}
	public Integer getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClassificacaoEtaria() {
		return classificacaoEtaria;
	}
	public void setClassificacaoEtaria(String classificacaEtaria) {
		this.classificacaoEtaria = classificacaEtaria;
	}
	public Boolean getExibicao3D() {
		return exibicao3D;
	}
	public void setExibicao3D(Boolean exibicao3d) {
		exibicao3D = exibicao3d;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", nomeFilme=" + nomeFilme
				+ ", genero=" + genero + ", classificacaEtaria="
				+ classificacaoEtaria + ", exibicao3D=" + exibicao3D
				+ ", duracao=" + duracao + "]";
	}
	
	
	
	

}
