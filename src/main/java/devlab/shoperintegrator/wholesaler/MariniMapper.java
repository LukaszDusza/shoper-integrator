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
public class MariniMapper extends DefaultHandler implements MapperFacade {
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
        if (qName.equalsIgnoreCase("b2b")) {
            currentObject = new OutputFile();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("EAN")) {
            String s = currentValue.toString();
            currentObject.setBarcode(s);
        }
        if (qName.equalsIgnoreCase("kod")) {
            String s = currentValue.toString();
            currentObject.setProductCode(s);
        }
        if (qName.equalsIgnoreCase("grupa")) {
            String s = currentValue.toString();
            currentObject.setProducer(s.split("/")[0]); //first piece is a producer name
        }
        if (qName.equalsIgnoreCase("nazwa")) {
            String s = currentValue.toString();
            currentObject.setName(s);
        }
        if (qName.equalsIgnoreCase("opis")) {
            String s = currentValue.toString();
            currentObject.setDescription(s);
        }
        if (qName.equalsIgnoreCase("VAT")) {
            String s = currentValue.toString();
            currentObject.setVat(s);
        }
        if (qName.equalsIgnoreCase("cena")) {
            String s = currentValue.toString().replace((char) 46, (char) 44); // . replace to ,
            currentObject.setPrice(s);
        }
        if (qName.equalsIgnoreCase("stan")) {
            String s = currentValue.toString();
            switch (s) {
                case "mała ilość":
                    currentObject.setStock("10");
                    break;
                case "średnia ilość":
                    currentObject.setStock("20");
                    break;
                case "duża ilość":
                    currentObject.setStock("30");
                    break;
                default:
                    currentObject.setStock("0"); //default value for 'brak'
            }
        }
        if (qName.equalsIgnoreCase("zdjecia")) {
            String s = currentValue.toString();
            String[] imgs = s.split(" ");
            if (imgs.length > 0) {
                try {
                    currentObject.setImages1(imgs[0]);
                    currentObject.setImages2(imgs[1]);
                    currentObject.setImages3(imgs[2]);
                    currentObject.setImages4(imgs[3]);
                    currentObject.setImages5(imgs[4]);
                    currentObject.setImages6(imgs[5]);
                    currentObject.setImages7(imgs[6]);
                    currentObject.setImages8(imgs[7]);
                    currentObject.setImages9(imgs[8]);
                    currentObject.setImages10(imgs[9]);
                    currentObject.setImages11(imgs[10]);
                    currentObject.setImages12(imgs[11]);
                    currentObject.setImages13(imgs[12]);
                    currentObject.setImages14(imgs[13]);
                    currentObject.setImages15(imgs[14]);
                    currentObject.setImages16(imgs[15]);
                    currentObject.setImages17(imgs[16]);
                    currentObject.setImages18(imgs[17]);
                    currentObject.setImages19(imgs[18]);
                    currentObject.setImages20(imgs[19]);
                } catch (IndexOutOfBoundsException e) {
                    // do nothing
                }
            }
        }
        if (qName.equalsIgnoreCase("b2b")) {
            currentObject.setUnit("szt.");
            currentObject.setDelivery("3 dni");
            currentObject.setAvailability("auto");
            currentObject.setActive("1");
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
