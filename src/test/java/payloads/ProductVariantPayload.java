package payloads;

public class ProductVariantPayload {
    private String size;

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getColorHex() {
        return colorHex;
    }

    public String getSku() {
        return sku;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    private String color;
    private String colorHex;
    private String sku;
    private int stock;
    private double price;

    public ProductVariantPayload(
            String size,
            String color,
            String colorHex,
            String sku,
            int stock,
            double price){
        this.size = size;
        this.color = color;
        this.colorHex = colorHex;
        this.sku = sku;
        this.stock = stock;
        this.price = price;
    }

}
