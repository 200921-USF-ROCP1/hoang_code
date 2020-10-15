package com.revature.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.classes.DemoClass;
import com.revature.classes.JsonClass;
import com.revature.classes.XmlClass;

public class App {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {
		//xmlMethod();
		//jsonMethod();
		
		//json marshalling and unmarshalling
		DemoClass json = new DemoClass(123, "JSON", true), jsonEmpty;
		System.out.println(marshalToJson(json));
		jsonEmpty = unmarshalFromJson(marshalToJson(json));
		System.out.println("'jsonEmpty' object filled: " + jsonEmpty.getI() + ", " + jsonEmpty.getS() + ", " + jsonEmpty.isB());
		
		//xml marshalling and unmarshalling
		DemoClass xml = new DemoClass(456, "XML", false), xmlEmpty;
		System.out.println(marshalToXml(xml));
		xmlEmpty = unmarshalFromXml(marshalToXml(xml));
		System.out.println("'xmlEmpty' object filled: " + xmlEmpty.getI() + ", " + xmlEmpty.getS() + ", " + xmlEmpty.isB());
		
		//Stretch
		System.out.println("\n- Stretch Below -\n");
		BufferedReader xmlData = new BufferedReader(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n"
				+ "<DemoClass>\r\n"
				+ "    <b>true</b>\r\n"
				+ "    <i>10</i>\r\n"
				+ "    <s>Hello</s>\r\n"
				+ "</DemoClass>"));
		BufferedReader jsonData = new BufferedReader(new StringReader("{\"i\":56,\"s\":\"Hi there!\",\"b\":false}"));
		jsonEmpty = unmarshalFromJson(jsonData);
		System.out.println("'jsonEmpty' object filled again: " + jsonEmpty.getI() + ", " + jsonEmpty.getS() + ", " + jsonEmpty.isB());
		xmlEmpty = unmarshalFromXml(xmlData);
		System.out.println("'xmlEmpty' object filled again: " + xmlEmpty.getI() + ", " + xmlEmpty.getS() + ", " + xmlEmpty.isB());
	}
	
	public static void jsonMethod() {
		JsonClass json = new JsonClass(123, "Hello", true), empty;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			String s = mapper.writeValueAsString(json);
			System.out.println(s);
			
			empty = mapper.readValue(s, JsonClass.class);
			System.out.println("'empty' object filled: " + empty.getI() + ", " + empty.getS() + ", " + empty.isB());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void xmlMethod() {
		XmlClass xml = new XmlClass(456, "World", false), empty;
		
		try {
			JAXBContext context = JAXBContext.newInstance(XmlClass.class);
			
			//Marshalling
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(xml, System.out);
			
			//Unmarshalling
			Unmarshaller unmarshaller = context.createUnmarshaller();
			empty = (XmlClass) unmarshaller.unmarshal(new StringReader(
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n"
					+ "<XmlClass>\r\n"
					+ "    <b>true</b>\r\n"
					+ "    <i>10</i>\r\n"
					+ "    <s>Hello</s>\r\n"
					+ "</XmlClass>"));
			System.out.println("'empty' object filled: " + empty.getI() + ", " + empty.getS() + ", " + empty.isB());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//XML
	public static String marshalToXml(DemoClass demoClass) {
		try {
			JAXBContext context = JAXBContext.newInstance(DemoClass.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			
			marshaller.marshal(demoClass, sw);
			return sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DemoClass unmarshalFromXml(String xml) {
		try {
			JAXBContext context = JAXBContext.newInstance(DemoClass.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			DemoClass demoClass = (DemoClass) unmarshaller.unmarshal(new StringReader(xml));
			return demoClass;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//JSON
	public static String marshalToJson(DemoClass demoClass) {
		try {
			return mapper.writeValueAsString(demoClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DemoClass unmarshalFromJson(BufferedReader json) {
		try {
			return mapper.readValue(json, DemoClass.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DemoClass unmarshalFromJson(String json) {
		try {
			return mapper.readValue(json, DemoClass.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Using Reader/BufferedReader
	public static DemoClass unmarshalFromXml(BufferedReader xml) {
		try {
			JAXBContext context = JAXBContext.newInstance(DemoClass.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			DemoClass demoClass = (DemoClass) unmarshaller.unmarshal(xml);
			return demoClass;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
