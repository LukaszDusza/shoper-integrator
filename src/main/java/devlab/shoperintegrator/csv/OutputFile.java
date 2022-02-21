package devlab.shoperintegrator.csv;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OutputFile {
    @CsvBindByName(column = "product_code")
    @CsvBindByPosition(position = 0)
    private String productCode;

    @CsvBindByName(column = "active")
    @CsvBindByPosition(position = 1)
    private String active;

    @CsvBindByName(column = "name")
    @CsvBindByPosition(position = 2)
    private String name;

    @CsvBindByName(column = "price")
    @CsvBindByPosition(position = 3)
    private String price;

    @CsvBindByName(column = "vat")
    @CsvBindByPosition(position = 4)
    private String vat;

    @CsvBindByName(column = "unit")
    @CsvBindByPosition(position = 5)
    private String unit;

    @CsvBindByName(column = "category")
    @CsvBindByPosition(position = 6)
    private String category;

    @CsvBindByName(column = "producer")
    @CsvBindByPosition(position = 7)
    private String producer;

    @CsvBindByName(column = "description")
    @CsvBindByPosition(position = 8)
    private String description;

    @CsvBindByName(column = "stock")
    @CsvBindByPosition(position = 9)
    private String stock;

    @CsvBindByName(column = "availability")
    @CsvBindByPosition(position = 10)
    private String availability;

    @CsvBindByName(column = "delivery")
    @CsvBindByPosition(position = 11)
    private String delivery;

    @CsvBindByName(column = "barcode")
    @CsvBindByPosition(position = 12)
    private String barcode;

    @CsvBindByName(column = "images 1")
    @CsvBindByPosition(position = 13)
    private String images1;

    @CsvBindByName(column = "images 2")
    @CsvBindByPosition(position = 14)
    private String images2;

    @CsvBindByName(column = "images 3")
    @CsvBindByPosition(position = 15)
    private String images3;

    @CsvBindByName(column = "images 4")
    @CsvBindByPosition(position = 16)
    private String images4;

    @CsvBindByName(column = "images 5")
    @CsvBindByPosition(position = 17)
    private String images5;

    @CsvBindByName(column = "images 6")
    @CsvBindByPosition(position = 18)
    private String images6;

    @CsvBindByName(column = "images 7")
    @CsvBindByPosition(position = 19)
    private String images7;

    @CsvBindByName(column = "images 8")
    @CsvBindByPosition(position = 20)
    private String images8;

    @CsvBindByName(column = "images 9")
    @CsvBindByPosition(position = 21)
    private String images9;
    @CsvBindByName(column = "images 10")
    @CsvBindByPosition(position = 22)
    private String images10;

    @CsvBindByName(column = "images 11")
    @CsvBindByPosition(position = 23)
    private String images11;

    @CsvBindByName(column = "images 12")
    @CsvBindByPosition(position = 24)
    private String images12;

    @CsvBindByName(column = "images 13")
    @CsvBindByPosition(position = 25)
    private String images13;

    @CsvBindByName(column = "images 14")
    @CsvBindByPosition(position = 26)
    private String images14;

    @CsvBindByName(column = "images 15")
    @CsvBindByPosition(position = 27)
    private String images15;

    @CsvBindByName(column = "images 16")
    @CsvBindByPosition(position = 28)
    private String images16;

    @CsvBindByName(column = "images 17")
    @CsvBindByPosition(position = 29)
    private String images17;

    @CsvBindByName(column = "images 18")
    @CsvBindByPosition(position = 30)
    private String images18;

    @CsvBindByName(column = "images 19")
    @CsvBindByPosition(position = 31)
    private String images19;

    @CsvBindByName(column = "images 20")
    @CsvBindByPosition(position = 32)
    private String images20;

    @CsvBindByPosition(position = 33)
    @CsvBindByName(column = "weight")
    private String weight;

    @CsvBindByName(column = "producer_code")
    @CsvBindByPosition(position = 34)
    private String producerCode;

    @CsvBindByPosition(position = 35)
    @CsvBindByName(column = "vendor_url")
    private String vendorURL;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = StringUtils.normalizeSpace(active);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.normalizeSpace(name);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = StringUtils.normalizeSpace(price);
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = StringUtils.normalizeSpace(vat);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = StringUtils.normalizeSpace(unit);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = StringUtils.normalizeSpace(category);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = StringUtils.normalizeSpace(producer);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = StringUtils.normalizeSpace(description);
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = StringUtils.normalizeSpace(stock);
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = StringUtils.normalizeSpace(availability);
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = StringUtils.normalizeSpace(delivery);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = StringUtils.normalizeSpace(barcode);
    }

    public String getImages1() {
        return images1;
    }

    public void setImages1(String images1) {
        this.images1 = StringUtils.normalizeSpace(images1);
    }

    public String getImages2() {
        return images2;
    }

    public void setImages2(String images2) {
        this.images2 = images2;
    }

    public String getImages3() {
        return images3;
    }

    public void setImages3(String images3) {
        this.images3 = images3;
    }

    public String getImages4() {
        return images4;
    }

    public void setImages4(String images4) {
        this.images4 = images4;
    }

    public String getImages5() {
        return images5;
    }

    public void setImages5(String images5) {
        this.images5 = images5;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = StringUtils.normalizeSpace(weight);
    }

    public String getProducerCode() {
        return producerCode;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = StringUtils.normalizeSpace(producerCode);
    }

    public String getVendorURL() {
        return vendorURL;
    }

    public void setVendorURL(String vendorURL) {
        this.vendorURL = StringUtils.normalizeSpace(vendorURL);
    }

    public String getImages6() {
        return images6;
    }

    public void setImages6(String images6) {
        this.images6 = images6;
    }

    public String getImages7() {
        return images7;
    }

    public void setImages7(String images7) {
        this.images7 = images7;
    }

    public String getImages8() {
        return images8;
    }

    public void setImages8(String images8) {
        this.images8 = images8;
    }

    public String getImages9() {
        return images9;
    }

    public void setImages9(String images9) {
        this.images9 = images9;
    }

    public String getImages10() {
        return images10;
    }

    public void setImages10(String images10) {
        this.images10 = images10;
    }

    public String getImages11() {
        return images11;
    }

    public void setImages11(String images11) {
        this.images11 = images11;
    }

    public String getImages12() {
        return images12;
    }

    public void setImages12(String images12) {
        this.images12 = images12;
    }

    public String getImages13() {
        return images13;
    }

    public void setImages13(String images13) {
        this.images13 = images13;
    }

    public String getImages14() {
        return images14;
    }

    public void setImages14(String images14) {
        this.images14 = images14;
    }

    public String getImages15() {
        return images15;
    }

    public void setImages15(String images15) {
        this.images15 = images15;
    }

    public String getImages16() {
        return images16;
    }

    public void setImages16(String images16) {
        this.images16 = images16;
    }

    public String getImages17() {
        return images17;
    }

    public void setImages17(String images17) {
        this.images17 = images17;
    }

    public String getImages18() {
        return images18;
    }

    public void setImages18(String images18) {
        this.images18 = images18;
    }

    public String getImages19() {
        return images19;
    }

    public void setImages19(String images19) {
        this.images19 = images19;
    }

    public String getImages20() {
        return images20;
    }

    public void setImages20(String images20) {
        this.images20 = images20;
    }

    @Override
    public String toString() {
        return "OutputFile{" +
                "productCode='" + productCode + '\'' +
                ", active='" + active + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", vat='" + vat + '\'' +
                ", unit='" + unit + '\'' +
                ", category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", stock='" + stock + '\'' +
                ", availability='" + availability + '\'' +
                ", delivery='" + delivery + '\'' +
                ", barcode='" + barcode + '\'' +
                ", images1='" + images1 + '\'' +
                ", images2='" + images2 + '\'' +
                ", images3='" + images3 + '\'' +
                ", images4='" + images4 + '\'' +
                ", images5='" + images5 + '\'' +
                ", weight='" + weight + '\'' +
                ", producerCode='" + producerCode + '\'' +
                ", vendorURL='" + vendorURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputFile outputFile = (OutputFile) o;
        return new EqualsBuilder().append(productCode, outputFile.productCode).append(active, outputFile.active).append(name, outputFile.name).append(price, outputFile.price).append(vat, outputFile.vat).append(unit, outputFile.unit).append(category, outputFile.category).append(producer, outputFile.producer).append(description, outputFile.description).append(stock, outputFile.stock).append(availability, outputFile.availability).append(delivery, outputFile.delivery).append(barcode, outputFile.barcode).append(images1, outputFile.images1).append(images2, outputFile.images2).append(images3, outputFile.images3).append(images4, outputFile.images4).append(images5, outputFile.images5).append(weight, outputFile.weight).append(producerCode, outputFile.producerCode).append(vendorURL, outputFile.vendorURL).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(productCode).append(active).append(name).append(price).append(vat).append(unit).append(category).append(producer).append(description).append(stock).append(availability).append(delivery).append(barcode).append(images1).append(images2).append(images3).append(images4).append(images5).append(weight).append(producerCode).append(vendorURL).toHashCode();
    }
}
