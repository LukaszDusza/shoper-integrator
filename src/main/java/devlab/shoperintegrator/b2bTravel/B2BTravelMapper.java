package devlab.shoperintegrator.b2bTravel;

import devlab.shoperintegrator.shoper.models.output.OutputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Component
public class B2BTravelMapper extends DefaultHandler {
    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private StringBuilder currentValue;
    private List<OutputFile> objects = new ArrayList<>();
    private OutputFile currentObject;
    private int imgCounter;

    public B2BTravelMapper() {
    }

    @Override
    public void startDocument() {
        objects = new ArrayList<>();
        currentValue = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase("Product")) {
            currentObject = new OutputFile();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("ItemEan")) {
            String s = currentValue.toString();
            currentObject.setBarcode(s);
        }
        if (qName.equalsIgnoreCase("ItemSymbol")) {
            String s = currentValue.toString();
            currentObject.setProductCode(s);
        }
        if (qName.equalsIgnoreCase("ProducerName")) {
            String s = currentValue.toString();
            currentObject.setProducer(s);
        }
        if (qName.equalsIgnoreCase("Name")) {
            String s = currentValue.toString();
            currentObject.setName(s);
        }
        if (qName.equalsIgnoreCase("LongDesc")) {
            String s = currentValue.toString();
            currentObject.setDescription(s);
        }
        if (qName.equalsIgnoreCase("CategoryName")) {
            String s = currentValue.toString();
            currentObject.setCategory(s);
        }
        if (qName.equalsIgnoreCase("CategoryName")) {
            String s = currentValue.toString();
            currentObject.setCategory(s);
        }
        if (qName.equalsIgnoreCase("Vat")) {
            String s = currentValue.toString();
            currentObject.setVat(s);
        }
        if (qName.equalsIgnoreCase("Net")) {
            String s = currentValue.toString();
            currentObject.setPrice(s);
        }
        if (qName.equalsIgnoreCase("Quantity")) {
            String s = currentValue.toString();
            currentObject.setStock(s);
            if (Integer.parseInt(s) > 0) {
                currentObject.setActive("1");
            } else {
                currentObject.setActive("0");
            }
        }
        if (qName.equalsIgnoreCase("ImageUrl")) {
            imgCounter ++;
            String s = currentValue.toString();
            if(imgCounter == 1) currentObject.setImages1(s);
            if(imgCounter == 2) currentObject.setImages2(s);
            if(imgCounter == 3) currentObject.setImages3(s);
            if(imgCounter == 4) currentObject.setImages4(s);
            if(imgCounter == 5) currentObject.setImages5(s);
        }
        if (qName.equalsIgnoreCase("Product")) {
            currentObject.setUnit("szt.");
            currentObject.setDelivery("3 dni");
            currentObject.setAvailability("auto");
            objects.add(currentObject);
            if(imgCounter == 0) {
                logger.warn("Product without image: {}. {}", currentObject.getProductCode(), currentObject.getName());
                currentObject.setActive("0");
            }
            imgCounter = 0;
        }
    }

    @Override
    public void endDocument() { /* document why this method is empty */ }

    public List<OutputFile> getObjects() {
        return objects;
    }

}
