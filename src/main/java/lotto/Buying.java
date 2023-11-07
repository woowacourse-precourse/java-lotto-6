package lotto;

public class Buying {
    private Integer buyingPrice;

    public Buying(String readLine) {
        Integer buyingPrice = validate(readLine);
        this.buyingPrice = buyingPrice;
    }

    public Integer getBuyingPrice() {
        return this.buyingPrice;
    }

    public Integer getBuyingCount() {
        return this.buyingPrice / 1000;
    }

    private Integer validate(String readLine) {
        String refinedReadLine = removeEmpty(readLine);
        checkDigit(refinedReadLine);
        Integer price = translateToPrice(refinedReadLine);
        checkMaxPrice(price);
        checkRest(price);
        return price;
    }

    private String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    private void checkDigit(String readLine) {
        if (readLine.length() > 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkMaxPrice(Integer price) {
        if (price > 100000) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRest(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private Integer translateToPrice(String refinedReadLine) {
        try {
            return Integer.parseInt(refinedReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
