package test;

import java.util.List;

import metier.dao.ArticleMetierImpl;
import metier.dao.IArticle;
import metier.entities.Article;

public class TestMetier {

	public static void main(String[] args) {
		IArticle metier = new ArticleMetierImpl();
		metier.addArticle(new Article("HGL", 1850, 15));
		metier.addArticle(new Article("MPlonl", 900, 52));
		metier.addArticle(new Article("KLMIO", 1150, 35));
		metier.addArticle(new Article("HHTG", 7800, 25));
		System.out.println("----------- Les articles------------- ");
		List<Article> articles = metier.articles();
		for (Article a : articles) {
			System.out.println(a.getIdAricle() + "  le nom des article sont : " + a.getNomArticle());
		}
		System.out.println("----------- Les article par mot cle ------------- ");
		List<Article> articlesA = metier.articleParMC("A");
		for (Article a : articlesA) {
			System.out.println(a.getIdAricle() + "  le nom des article sont : " + a.getNomArticle());
		}

		System.out.println("----------- Get article ------------- ");
		Article ar = metier.getArticle(5L);
		System.out.println("Le produit rechercher est : " + ar.getNomArticle());

		System.out.println("----------- UPdate article ------------- ");
		Article art = metier.getArticle(9L);
		System.out.println("le nom de l'article avant :  " + art.getNomArticle());
		art.setNomArticle("AHMED");
		art.setPrixArticle(1559);
		metier.updateArticle(art);

		System.out.println("le nom de l'article apres :  " + art.getNomArticle());
		System.out.println("----------- delete article ------------- ");
		metier.deleteArticle(7L);
	}

}
