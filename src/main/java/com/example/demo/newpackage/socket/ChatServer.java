package com.example.demo.newpackage.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer{
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private String username;
	public static void main(String[] args){
		ChatServer chatServer = new ChatServer();
		chatServer.startServer(4000);
	}

	public void startServer(int port){
		try {
			serverSocket = new ServerSocket(port);
			System.out.printf("Server Started on port %s%n",port);
			socket = serverSocket.accept();
			System.out.println("Client Connected");
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println("Please Insert Your Username?");
			printWriter.flush();
			username = bufferedReader.readLine();
			printWriter.println(String.format("Welcome %s",username));
			printWriter.flush();
			String message;
			while((message = bufferedReader.readLine())!=null){
				System.out.printf("%s >> %s%n",username,message);
				printWriter.println(String.format("Echo: %s",message));
				printWriter.flush();
				if("bye".equals(message)){
					socket.close();
					break;
				}
			}

		}catch (IOException exception){
			System.out.println(exception.getMessage());
		}
		}
}