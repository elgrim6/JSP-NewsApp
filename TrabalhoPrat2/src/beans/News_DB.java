package beans;

import java.io.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class News_DB implements Serializable
{
   public Hashtable tabela;
   int Id=1;  // still not used
//=========================================
public News_DB(){
   tabela = new Hashtable();
}
//=========================================
public void storeNewNews(String titulo, NewsInfo n){  
  System.out.println("DEBUG: storeNewNews: tema="+titulo);
  try {
	ReadNews();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  if(NewsExist(titulo))
  {
	  tabela.put(titulo,n);
	  Id++;
  }
  
  
  try{
    FileOutputStream datafile= new FileOutputStream ("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\news_db.dat");
    ObjectOutputStream obj= new ObjectOutputStream (datafile);  

    obj.writeObject (tabela); //gravar as not�cias.
       
    //FIM escrever dados no ficheiro
    obj.close();
    datafile.close();
  }catch(IOException error) {System.out.println("Erro de escrita no ficheiro");}
}


	
	//*************************************************************
public void ReadNews()throws ClassNotFoundException{
 //Recupera not�cias
  NewsInfo n; 							//Guardados no  disco
   try{
    FileInputStream datafile= new FileInputStream ("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\news_db.dat");
    ObjectInputStream obj= new ObjectInputStream (datafile);
  		  
    	tabela= (Hashtable)obj.readObject ();        //le objectos no ficheiro.
//FIM ler dados no ficheiro
    obj.close();
    datafile.close();
  }catch(IOException error) {System.out.println("Erro de leitura no ficheiro");}
}	


//=====================================
   public boolean checkNews(String Tema, String Titulo){     
     NewsInfo n=(NewsInfo)tabela.get(Titulo);
     if((n == null)||(Titulo == null))
       return false;
     String titulo=n.getTitulo();
     System.out.println("DEBUG: checkUser: login="+Tema+ "Password= "+titulo+
                         "Password_Log="+Titulo);
     if(titulo.compareTo(Titulo)==0)
       return true;
     else
     return false;
   }   
//=========================================
   public boolean NewsExist(String Titulo){  
     NewsInfo n=(NewsInfo)tabela.get(Titulo);
     if(n==null)
       return false;
     else
       return true;  
      }   
//============================================
 
}