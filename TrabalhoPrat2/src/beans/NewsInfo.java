package beans;
import java.io.*;

public class NewsInfo implements Serializable
{
  String tema;
  String titulo;
  String texto;
  

    	
  public NewsInfo(){}
   
	
public NewsInfo(String tema, String titulo,String texto)
 {
   this.tema = tema;
   this.titulo = titulo;
   this.texto = texto;
  }
  
 public void setTema( String value )
  {
    tema = value;
  }

    public void setTitulo( String value )
    {
       titulo = value;
    }

   public void setTexto( String value )
    {
      texto = value;
    }

		
    public String getTema() { return tema; }
    public String getTitulo() { return titulo; }
    public String getTexto() { return texto; }

}