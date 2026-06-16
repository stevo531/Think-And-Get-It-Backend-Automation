package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateProductPayload {

    private String name;
    private String description;
    private double price;
    private double comparePrice;
    private String categoryId;
    private List<String> tags;

    @JsonProperty("isFeatured")
    private boolean isFeatured;
    @JsonProperty("isFlashSale")
    private boolean isFlashSale;
    private double flashSalePrice;

    public UpdateProductPayload(
            String name,
            String description,
            double price,
            double comparePrice,
            List<String> tags,
            boolean isFeatured,
            boolean isFlashSale,
            double flashSalePrice
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.comparePrice = comparePrice;
        this.tags = tags;
        this.isFeatured = isFeatured;
        this.isFlashSale = isFlashSale;
        this.flashSalePrice = flashSalePrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getComparePrice() {
        return comparePrice;
    }

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("isFeatured")
    public boolean getIsFeatured() {
        return isFeatured;
    }

    @JsonProperty("isFlashSale")
    public boolean getIsFlashSale() {
        return isFlashSale;
    }

    public double getFlashSalePrice() {
        return flashSalePrice;
    }
}