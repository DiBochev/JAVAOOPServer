/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.javaOOPProject.server.registeredClients.RegisteredClients;
import com.javaOOPProject.server.registeredClients.RegisteredClients.Client;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.Marshaller;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author fgg12
 */
public class XMLManager {

    private static RegisteredClients rc;

    public static String createResponse(Client client, boolean isLogged) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("response");
            doc.appendChild(rootElement);

            Element loginSuccess = doc.createElement("loginSuccess");
            loginSuccess.appendChild(doc.createTextNode(String.valueOf(isLogged)));
            rootElement.appendChild(loginSuccess);

            Element serverMessage = doc.createElement("serverMessage");
            serverMessage.appendChild(doc.createTextNode("error0"));
            rootElement.appendChild(serverMessage);

            Element permissionForCrypt = doc.createElement("permissionForCrypt");
            permissionForCrypt.appendChild(doc.createTextNode(String.valueOf(client.isPermissionForCrypt())));
            rootElement.appendChild(permissionForCrypt);

            if (client.getCardNumbers() != null) {
                for (int i = 0; i < client.getCardNumbers().size() - 1; i++) {
                    Element card = doc.createElement("card");
                    card.appendChild(doc.createTextNode(client.getCardNumbers().get(i).toString()));
                    rootElement.appendChild(card);
                }
            } else {
                Element card = doc.createElement("card");
                card.appendChild(doc.createTextNode(""));
                rootElement.appendChild(card);
            }

            // write the content into xml String
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            System.out.println(writer.getBuffer().toString());

            return writer.getBuffer().toString();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RegisteredClients loadData(String path) throws JAXBException, IOException {

        String xmlData = readFile(path);

        JAXBContext context = JAXBContext.newInstance(RegisteredClients.class);
        Unmarshaller un = context.createUnmarshaller();
        StringReader sReader = new StringReader(xmlData);
        RegisteredClients reg = (RegisteredClients) un.unmarshal(sReader);
        XMLManager.rc = new RegisteredClients(reg);
        return reg;

    }

    private static String readFile(String path) throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }
        return stringBuilder.toString();
    }

    public static void parceToXMLString(RegisteredClients reg, String path) throws JAXBException, FileNotFoundException {
        XMLManager.rc = reg;
        JAXBContext context = JAXBContext.newInstance(RegisteredClients.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream os = new FileOutputStream(path);
        m.marshal(reg, os);
    }

//    public static RegisteredClients getClients(){
//        return XMLManager.rc;
//    }
    public static boolean isRegistered(ObjectInputStream request) {
        
        
         String temp = null;
        try {
            temp = request.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
		Pattern pattern = Pattern.compile("<username>(.+?)</username>");
		Matcher matcher = pattern.matcher(temp);
		matcher.find();
		String username = matcher.group(1);
		
		pattern = Pattern.compile("<password>(.+?)</password>");
		matcher = pattern.matcher(temp);
		matcher.find();
		String password = matcher.group(1);
                
                for (int i = 0; i < rc.getArraySize(); i++) {
                    if (rc.getClientByIndex(i).getUsername().equals(username) && rc.getClientByIndex(i).getPassword().equals(password)) {
                        return true;
                    }
        }
        
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder;
//        NodeList nListUserName = null;
//        NodeList nListPassword = null;
//        
//        System.out.println("recieved message");
//        try {
//            dBuilder = dbFactory.newDocumentBuilder();
//            dbFactory.setValidating(false);
//            
//            
//            Document doc = dBuilder.parse(request);
//            System.out.println("recieved message");
//            doc.getDocumentElement().normalize();
//            nListUserName = doc.getElementsByTagName("username");
//            nListUserName = doc.getElementsByTagName("password");
//
//            System.out.println("recieved message");
//
//            String username = nListUserName.item(0).getTextContent();
//            String password = nListPassword.item(0).getTextContent();
//
//            System.out.println(username);
//            System.out.println(password);
//
//        } catch (SAXException ex) {
//            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        for (int i = 0; i < XMLManager.rc.getArraySize() ; i++) {
//            
//            if (XMLManager.rc.getClientByIndex(i).getUsername().toString().equals(nListUserName.item(0).getNodeValue().toString()) &&
//                XMLManager.rc.getClientByIndex(i).getPassword().toString().equals(nListPassword.item(0).getNodeValue().toString()) ) {
//                return true;
//            }
//            
//        }
        return false;
    }
}
