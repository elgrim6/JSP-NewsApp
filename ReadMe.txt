Projecto Elaborado como parte de um trabalho prático na cadeira de Sistemas Distribuídos no curso de Engenharia Informática do ISCTEM.

Guia de instalação
Nos dois servidores
1-Instalar jdk 19 ou mais recente
2-Instalar Apache Tomcat 10.1

No servidor 1
1-Copiar a pasta serv1 para o directório webapps do tomcat
2-Importar o projecto TrabalhoPrat2 para o eclipse
3-Alterar a variável server (linha 22) para o ip do servidor 2 na classe NewsServlet
4-Compilar a classe
5-Copiar o ficheiro NewsServlet.class para o directório "serv1\WEB-INF\classes\servlet" dentro do directório webapps

No servidor 2
1-Copiar a pasta serv2 para o directório webapps do tomcat
2-Importar o Projecto TrabalhoPrat2 para o eclipse

Guia de uso
No servidor 2 
1-Correr a classe TCPServer no projecto TrabalhoPrat2
2-Inicializar o tomcat
No servidor 1
1-Inicializar o tomcat
2-No web browser, abrir o link "localhost:8080/serv1/login.html" (primeiro abrir "localhost:8080/serv1/signup.html" para registar usuário)
3-Apos efectuar o login, ira ter acesso ao back office, onde poderá digitar a noticia a ser enviada

Leitores
1-No web browser, abrir o link "[ip do servidor 2]:8080/serv2/read-news.jsp"
  
