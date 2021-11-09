package devlab.shoperintegrator.bbtb;

import devlab.shoperintegrator.bbtb.BBTBMapper;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;

public class BBTBParserXML {

    public static BBTBMapper handler;

    private BBTBParserXML() { }

    public static void parseFile(String pathToFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        } catch (ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            SAXParser saxParser = factory.newSAXParser();
            handler = new BBTBMapper();
            saxParser.parse(pathToFile, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
