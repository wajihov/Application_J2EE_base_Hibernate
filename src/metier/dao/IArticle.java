package metier.dao;

import java.util.List;

import metier.entities.Article;

public interface IArticle {

	public void addArticle(Article article);

	public List<Article> articles();

	public Article getArticle(Long id);

	public List<Article> articleParMC(String mc);

	public void deleteArticle(Long id);

	public void updateArticle(Article article);

}
