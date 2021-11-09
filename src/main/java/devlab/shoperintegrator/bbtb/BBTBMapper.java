package devlab.shoperintegrator.bbtb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class BBTBMapper extends DefaultHandler {
    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Value("${csv.write.file.path}")
    private StringBuilder currentValue;
    private List<BBTB> objects = new ArrayList<>();
    private BBTB currentObject;
    private String currentAttr;

    public BBTBMapper() {
    }

    @Override
    public void startDocument() {
        objects = new ArrayList<>();
        currentValue = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase("o")) {
            currentObject = new BBTB();
            String productCode = attributes.getValue("id");
            currentObject.setProductCode(productCode);
            String url = attributes.getValue("url");
            currentObject.setVendorURL(url);
            // String available = attributes.getValue("avail");
            currentObject.setAvailability("auto");
            String stock = attributes.getValue("stock");
            currentObject.setStock(stock);
            if (Integer.parseInt(stock) > 0) {
                currentObject.setActive("1");
            } else {
                currentObject.setActive("0");
            }
            String weight = attributes.getValue("weight");
            currentObject.setWeight(weight);
        }
        if (qName.equalsIgnoreCase("main")) {
            String image1 = attributes.getValue("url");
            currentObject.setImages1(image1);
        }
        if (qName.equalsIgnoreCase("a")) {
            currentAttr = attributes.getValue("name");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("cat")) {
            String category = currentValue.toString();
            currentObject.setCategory(category);
        }
        if (qName.equalsIgnoreCase("name")) {
            String name = currentValue.toString();
            currentObject.setName(name);
        }
        if (qName.equalsIgnoreCase("desc")) {
            String description = currentValue.toString();
            currentObject.setDescription(description);
        }
        if ("Producent".equals(currentAttr)) {
            currentObject.setProducer(currentValue.toString());
            currentAttr = null;
        }
        if ("Kod_producenta".equals(currentAttr)) {
            currentObject.setProducerCode(currentValue.toString());
            currentAttr = null;
        }
        if ("EAN".equals(currentAttr)) {
            currentObject.setBarcode(currentValue.toString());
            currentAttr = null;
        }
        if (qName.equalsIgnoreCase("cena_srp")) {
            String price = currentValue.toString();
            currentObject.setPrice(price);
        }
        if (qName.equalsIgnoreCase("o")) {
            currentObject.setUnit("szt.");
            currentObject.setVat("23");
            currentObject.setDelivery("3 dni");
            objects.add(currentObject);
        }
    }

    @Override
    public void endDocument() { /* document why this method is empty */ }

    public List<BBTB> getObjects() {
        return objects;
    }
}
