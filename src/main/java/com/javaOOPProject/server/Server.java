/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author fgg12
 */
public class Server {

	private final int PORT = 12345;
	private ServerSocket server;
	private ExecutorService clientPool;
	
	public Server(){
		initializeServer();
		clientPool = Executors.newCachedThreadPool();
	}
	
	private void initializeServer(){
		try {
			server = new ServerSocket(this.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() throws IOException{
		while (true) {
			executeClient(new RequestHandler(server.accept()));
		}
	}
	
	private void executeClient(RequestHandler rh){
		clientPool.execute(rh);
	}

        public void stop() throws IOException{
            server.close();
        }
}
