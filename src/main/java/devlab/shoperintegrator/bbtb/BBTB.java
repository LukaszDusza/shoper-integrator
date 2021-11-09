package devlab.shoperintegrator.bbtb;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BBTB {
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

    @CsvBindByPosition(position = 18)
    @CsvBindByName(column = "weight")
    private String weight;

    @CsvBindByName(column = "producer_code")
    @CsvBindByPosition(position = 19)
    private String producerCode;

    @CsvBindByPosition(position = 20)
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

    @Override
    public String toString() {
        return "BBTB{" +
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
        BBTB bbtb = (BBTB) o;
        return new EqualsBuilder().append(productCode, bbtb.productCode).append(active, bbtb.active).append(name, bbtb.name).append(price, bbtb.price).append(vat, bbtb.vat).append(unit, bbtb.unit).append(category, bbtb.category).append(producer, bbtb.producer).append(description, bbtb.description).append(stock, bbtb.stock).append(availability, bbtb.availability).append(delivery, bbtb.delivery).append(barcode, bbtb.barcode).append(images1, bbtb.images1).append(images2, bbtb.images2).append(images3, bbtb.images3).append(images4, bbtb.images4).append(images5, bbtb.images5).append(weight, bbtb.weight).append(producerCode, bbtb.producerCode).append(vendorURL, bbtb.vendorURL).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(productCode).append(active).append(name).append(price).append(vat).append(unit).append(category).append(producer).append(description).append(stock).append(availability).append(delivery).append(barcode).append(images1).append(images2).append(images3).append(images4).append(images5).append(weight).append(producerCode).append(vendorURL).toHashCode();
    }
}
