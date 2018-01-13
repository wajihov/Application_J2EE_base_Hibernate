package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
@SuppressWarnings("serial")
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDARTICLE")
	private Long idAricle;
	@Column(name = "NOMARTICLE", length = 70)
	private String nomArticle;
	private double prixArticle;
	private int quantiteArticle;

	public Long getIdAricle() {
		return idAricle;
	}

	public void setIdAricle(Long idAricle) {
		this.idAricle = idAricle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(double prixArticle) {
		this.prixArticle = prixArticle;
	}

	public int getQuantiteArticle() {
		return quantiteArticle;
	}

	public void setQuantiteArticle(int quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}

	public Article(String nomArticle, double prixArticle, int quantiteArticle) {
		super();
		this.nomArticle = nomArticle;
		this.prixArticle = prixArticle;
		this.quantiteArticle = quantiteArticle;
	}

	public Article() {
		super();
	}

}