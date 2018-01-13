package metier.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import metier.entities.Article;
import util.HibernateUtil;

public class ArticleMetierImpl implements IArticle {

	@Override
	public void addArticle(Article article) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(article);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public List<Article> articles() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("Select a From Article a");
		@SuppressWarnings("unchecked")
		List<Article> articles = query.list();
		session.getTransaction().commit();
		return articles;
	}

	@Override
	public Article getArticle(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object art = session.get(Article.class, id);
		if (art == null)
			throw new RuntimeException("Article introuvable");
		session.getTransaction().commit();
		return (Article) art;
	}

	@Override
	public List<Article> articleParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("Select a From Article a where a.nomArticle like :x");
		query.setParameter("x", "%" + mc + "%");
		@SuppressWarnings("unchecked")
		List<Article> articles = query.list();
		session.getTransaction().commit();
		return articles;
	}

	@Override
	public void deleteArticle(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object art = session.get(Article.class, id);
		if (art == null)
			throw new RuntimeException("Article introuvable");
		session.delete(art);
		session.getTransaction().commit();
	}

	@Override
	public void updateArticle(Article article) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(article);
		session.getTransaction().commit();
	}

}