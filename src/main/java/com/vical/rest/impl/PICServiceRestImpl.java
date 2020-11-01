package com.vical.rest.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pusher.rest.Pusher;
import com.vical.domain.Persona;
import com.vical.domain.SendSocket;
import com.vical.domain.User;
import com.vical.rest.IPICServiceRest;
import com.vical.service.IPersonaService;

import io.socket.client.IO;
import io.socket.client.Socket;

@Component
public class PICServiceRestImpl implements IPICServiceRest {
	
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private Pusher pusherWebsocket;
	

	@Override
	public Persona obtenerDatosPersona(String tipoDocumento, String numeroDocumento) throws RuntimeException {
		return personaService.obtenerDatosPersona(tipoDocumento);
	}

	@Override
	public String verificarService(String argumento) {
		Socket socket = null;
		try {
			socket = IO.socket("https://quiet-tundra-41266.herokuapp.com");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		socket.connect();
		
		List<User> usuarios = new ArrayList<>();
		usuarios.add(new User("Vical", "Rodriguez", "Admin", 12));
		usuarios.add(new User("Naruto", "Uzumaki", "User", 14));
		Gson gson = new Gson();
		SendSocket sendSocket = new SendSocket();
		sendSocket.setEventName("canal");
		sendSocket.setBody(gson.toJson(usuarios));
		socket.emit("job-validator", gson.toJson(sendSocket));
		
//		if(StringUtils.isEmpty(argumento)) {
//			throw new RuntimeException();
//		} else {
//			List<User> usuarios = new ArrayList<>();
//			usuarios.add(new User("Vical", "Rodriguez", "Admin", 12));
//			usuarios.add(new User("Naruto", "Uzumaki", "User", 14));
//			Gson gson = new Gson();
//			pusherWebsocket.trigger("mi-canal", "mi-evento", gson.toJson(usuarios));
			return "Exito";
//		}
	}

	
	public void verificarService(List<User> users) {
		
		Socket socket = null;
		try {
			socket = IO.socket("http://localhost:3000");
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
		}
		socket.connect();
		
		List<User> usuarios = new ArrayList<>();
		usuarios.add(new User("Vical", "Rodriguez", "Admin", 12));
		usuarios.add(new User("Naruto", "Uzumaki", "User", 14));
		Gson gson = new Gson();
		socket.emit("evento", gson.toJson(usuarios));
		
//		Configuration configuration = new Configuration();
//		configuration.setHostname("192.168.88.68");
//		configuration.setPort(4000);
//		final SocketIOServer server = new SocketIOServer(configuration);
		
		//host: 192.168.88.68
		//port: 4000
		//pusherWebsocket.trigger("mi-canal", "mi-evento", gson.toJson(users));
		
	}
}