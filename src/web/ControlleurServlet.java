package web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.ArticleMetierImpl;
import metier.dao.IArticle;
import metier.entities.Article;

@WebServlet("/ControlleurServlet")
public class ControlleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IArticle metier;

	public ControlleurServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		metier = new ArticleMetierImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("l'action est : " + action);
		if (action != null) {
			if (action.equals("Save")) {
				try {
					String nom = request.getParameter("nomArt");
					double prix = Double.parseDouble(request.getParameter("prix"));
					int qte = Integer.parseInt(request.getParameter("qte"));
					metier.addArticle(new Article(nom, prix, qte));
				} catch (NumberFormatException e) {
					request.setAttribute("erreur", e.getMessage());
					e.printStackTrace();
				}
			} else if (action.equals("delete")) {
				Long id = Long.parseLong(request.getParameter("id"));
				metier.deleteArticle(id);
			} else if (action.equals("modifier")) {
				Long id = Long.parseLong(request.getParameter("id"));
				Article article = metier.getArticle(id);
				request.setAttribute("article", article);
			} else if (action.equals("Update")) {
				try {
					Long id = Long.parseLong(request.getParameter("id"));
					String nom = request.getParameter("nomArt");
					double prix = Double.parseDouble(request.getParameter("prix"));
					int qte = Integer.parseInt(request.getParameter("qte"));
					Article article = new Article(nom, prix, qte);
					article.setIdAricle(id);
					metier.updateArticle(article);
				} catch (Exception e) {
					request.setAttribute("erreur", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("articles", metier.articles());
		request.getRequestDispatcher("vues/index.jsp").forward(request, response);

	}

}
