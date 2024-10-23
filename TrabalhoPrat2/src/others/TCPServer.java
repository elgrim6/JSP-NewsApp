package others;

// TCPServer1.java: single thread server
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*; 
import beans.NewsInfo;
import beans.News_DB;

public class TCPServer{ 
	public static void main(String args[]) throws IOException{  
		int serverPort = 9000; //server a escuta 
		ObjectInputStream in; 
		ObjectOutputStream out;
			
		String resposta;
		Socket clientSocket=null;
		ServerSocket listenSocket=null;//estabelece o canal de comunicacao
		
		listenSocket = new ServerSocket(serverPort); 
		
		NewsInfo n = new NewsInfo(); //uma not�cia
		while(true){
			System.out.println("� espera de ligacao no socket "+serverPort);
			while(true)
			{
				try{ 
				    clientSocket = listenSocket.accept(); //devolve um obj do tipo socket
					
				    in = new ObjectInputStream(clientSocket.getInputStream()); 
					out = new ObjectOutputStream(clientSocket.getOutputStream());
				
					while(true){
				
				      	n = (NewsInfo)in.readObject(); 
						
						System.out.println("Recebeu: "+n);
						News_DB newsDB=new News_DB();
						newsDB.storeNewNews(n.getTitulo(), n);
						
						out.writeBoolean(true);
						
						try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						in.close();
						out.close();
						clientSocket.close();
				
				    }// while
				  }catch(ClassNotFoundException e) {System.out.println("Erro");
				  }catch (SocketException e){System.out.println("Socket:" + e); 
				  }catch(EOFException e){System.out.println("EOF:" + e); 
				  }catch(IOException e){System.out.println("IO:" + e);}
			}
		//} 
		}
	}
}