package devlab.shoperintegrator.wholesaler;

import devlab.shoperintegrator.csv.MapperFacade;
import devlab.shoperintegrator.csv.OutputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Component
public class SuavinexMapper extends DefaultHandler implements MapperFacade {
    public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private StringBuilder currentValue;
    private List<OutputFile> objects = new ArrayList<>();
    private OutputFile currentObject;

    @Override
    public void startDocument() {
        objects = new ArrayList<>();
        currentValue = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase("item")) {
            currentObject = new OutputFile();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("ean_code")) {
            String s = currentValue.toString();
            currentObject.setBarcode(s);
            currentObject.setProductCode(s);
        }
        if (qName.equalsIgnoreCase("category_name")) {
            String s = currentValue.toString()
                    .replace("<![CDATA[", "")
                    .replace("]]", "")
                    .trim();
            currentObject.setCategory(s);
        }
        if (qName.equalsIgnoreCase("name")) {
            String s = currentValue.toString()
                    .replace("<![CDATA[", "")
                    .replace("]]", "")
                    .trim();
            currentObject.setName(s);
        }
        if (qName.equalsIgnoreCase("description")) {
            String s = currentValue.toString()
                    .replace("<![CDATA[", "")
                    .replace("]]", "")
                    .trim();
            currentObject.setDescription(s);
        }
        if (qName.equalsIgnoreCase("price")) {
            String s = currentValue.toString().replace((char) 46, (char) 44); // . replace to ,
            currentObject.setPrice(s);
        }
        if (qName.equalsIgnoreCase("is_available")) {
            String s = currentValue.toString();
            if ("true".equals(s)) {
                currentObject.setStock("20");
            } else {
                currentObject.setStock("0");
            }
        }
        if (qName.equalsIgnoreCase("image")) {
            String s = currentValue.toString();
            currentObject.setImages1(s);
        }

        if (qName.equalsIgnoreCase("item")) {
            currentObject.setUnit("szt.");
            currentObject.setDelivery("3 dni");
            currentObject.setAvailability("auto");
            currentObject.setActive("1");
            currentObject.setProducer("SUAVINEX");
            objects.add(currentObject);
        }
    }

    @Override
    public void endDocument() { /* document why this method is empty */ }


    @Override
    public List<OutputFile> getObjects() {
        return objects;
    }
}
