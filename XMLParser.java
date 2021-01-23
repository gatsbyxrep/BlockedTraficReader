package com.company;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.util.Date;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class XMLParser implements IParseStrategy {
    @Override
    public ArrayList<BlockedTrafficInfo> parse(String fileText) {
        ArrayList<BlockedTrafficInfo> infos = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(fileText));
            Document doc = dBuilder.parse(inputSource);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("block_traffic");
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)node;
                    int code = Integer.parseInt(element.getElementsByTagName("kod").item(0).getTextContent());
                    String orderNumber = element.getElementsByTagName("nomer_rasporjazhenija").item(0).getTextContent();
                    String costumer = element.getElementsByTagName("zakazchik").item(0).getTextContent();
                    String district =  element.getElementsByTagName("rajon").item(0).getTextContent();
                    String address =  element.getElementsByTagName("adres").item(0).getTextContent();
                    Date startDate = new SimpleDateFormat("yyyyMMdd").parse(element.getElementsByTagName("d.n.ogr").item(0).getTextContent());
                    Date endDate = new SimpleDateFormat("yyyyMMdd").parse(element.getElementsByTagName("d.o.ogr").item(0).getTextContent());

                    infos.add(new BlockedTrafficInfo(code, orderNumber, costumer, district, address, startDate, endDate));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return infos;
    }
}
