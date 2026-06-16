package payloads;

import java.util.List;

public class CreateProductPayload {

    private String name;
    private String description;
    private double price;
    private double comparePrice;
    private String categoryId;
    private List<String> tags;
    private boolean isFeatured;
    private boolean isFlashSale;
    private double flashSalePrice;
    private List<ProductVariantPayload> variants;


    public CreateProductPayload(
            String name,
            String description,
            double price,
            double comparePrice,
            String categoryId,
            List<String> tags,
            boolean isFeatured,
            boolean isFlashSale,
            double flashSalePrice,
            List<ProductVariantPayload> variants
    ) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.comparePrice = comparePrice;
        this.categoryId = categoryId;
        this.tags = tags;
        this.isFeatured = isFeatured;
        this.isFlashSale = isFlashSale;
        this.flashSalePrice = flashSalePrice;
        this.variants = variants;
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

    public String getCategoryId() {
        return categoryId;
    }

    public List<String> getTags() {
        return tags;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public boolean isFlashSale() {
        return isFlashSale;
    }

    public double getFlashSalePrice() {
        return flashSalePrice;
    }

    public List<ProductVariantPayload> getVariants() {
        return variants;
    }
}