package devlab.shoperintegrator.csv;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ParserXML {

    private ParserXML() {
    }

    public static void parseFile(String pathToFile, Object object) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        } catch (ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(pathToFile, (DefaultHandler) object);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
