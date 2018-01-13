<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>I N D E X</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
	function confirmation(id) {
		var rep = confirm("Ëtes vous sure de le supprimer?");
		if (rep == true)
			document.location = "controlleur.do?id=" + id + "&action=delete";
	}
</script>
</head>
<body>
	<div align="center">
		<form action="controlleur.do" method="post">
			<table class="table2">
				<tr>
					<th colspan="2">Ajouter un article</th>
				</tr>
				<c:if test="${article!=null }">
					<tr>
						<td>Id</td>
						<td>${article.idAricle }<input type="hidden" name="id"
							value="${article.idAricle }">
						</td>
					</tr>
				</c:if>

				<tr>
					<td>Nom article</td>
					<td><input type="text" name="nomArt" required="required"
						value="${article.nomArticle }"></td>
				</tr>
				<tr>
					<td>Quantite</td>
					<td><input type="text" name="qte"
						value="${article.quantiteArticle }"></td>
				</tr>
				<tr>
					<td>Prix</td>
					<td><input type="text" name="prix"
						value="${article.prixArticle }"></td>
				</tr>
				<tr>
					<td><input type="reset" value="Annuler" class="btn"></td>
					<c:if test="${article==null }">
						<td><input type="submit" value="Save" name="action"
							class="btn"></td>
					</c:if>
					<c:if test="${article!=null }">
						<td><input type="submit" value="Update" name="action"
							class="btn"></td>
					</c:if>
				</tr>
			</table>

		</form>
	</div>
	<c:if test="${erreur!=null }">
		<div align="center" class="erreur">${erreur }</div>
	</c:if>
	

	<div align="center">
		<table class="table1">
			<tr>
				<th>ID</th>
				<th>Nom Article</th>
				<th>Prix</th>
				<th>Quantite</th>
			</tr>
			<c:forEach items="${articles}" var="a">
				<tr>
					<td>${a.idAricle }</td>
					<td>${a.nomArticle }</td>
					<td>${a.prixArticle }</td>
					<td>${a.quantiteArticle }</td>
					<!-- 	<td><a href="controlleur.do?id=${a.idAricle }&action=delete">Suprimer</a>
					</td>  -->
					<td><a href="javascript:confirmation('${a.idAricle }')">Suprimer</a>
					</td>
					<td><a href="controlleur.do?id=${a.idAricle }&action=modifier">Modifier</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>