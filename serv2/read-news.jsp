

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="beans.News_DB" %>
<%@ page import="beans.NewsInfo" %>

<%
    News_DB newsDB = new News_DB();
    newsDB.ReadNews();
    List<String> temas = new ArrayList<>();
    temas.add("noticias-gerais");
    temas.add("avisos");
    temas.add("exames");
    temas.add("desporto");
    temas.add("eventos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notícias do ISCTEM</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #0066cc;
        }

        .news-container {
            display: flex;
            flex-wrap: wrap;
        }

        .news-card {
            width: 300px;
            border: 1px solid #ddd;
            margin: 10px;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            margin-right: 10px;
        }

        select {
            padding: 8px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h1>Notícias do ISCTEM</h1>

    <label for="temaSelect">Filtrar por Tema:</label>
    <select id="temaSelect" onchange="filterNews()">
        <option value="all">Todos</option>
        <% for (String tema : temas) { %>
            <option value="<%= tema %>"><%= tema %></option>
        <% } %>
    </select>

    <div class="news-container" id="newsContainer">
        <% if (newsDB.tabela.isEmpty()) { %>
            <p>Não há notícias disponíveis.</p>
        <% } else {
            for (Enumeration<String> keys = newsDB.tabela.keys(); keys.hasMoreElements();) {
                String titulo = keys.nextElement();
                NewsInfo news = (NewsInfo) newsDB.tabela.get(titulo); %>
                <div class="news-card">
                    <h2><%= news.getTitulo() %></h2>
                    <p>Tema: <strong><%= news.getTema() %></strong></p>
                    <p><%= news.getTexto() %></p>
                </div>
        <% }
        } %>
    </div>

    <script>
        function filterNews() {
            var selectedTema = document.getElementById("temaSelect").value;
            var newsCards = document.getElementsByClassName("news-card");

            for (var i = 0; i < newsCards.length; i++) {
                var newsCard = newsCards[i];
                var newsTema = newsCard.querySelector("p strong").textContent.replace("Tema: ", "");

                if (selectedTema === "all" || newsTema === selectedTema) {
                    newsCard.style.display = "block";
                } else {
                    newsCard.style.display = "none";
                }
            }
        }
    </script>
</body>
</html>