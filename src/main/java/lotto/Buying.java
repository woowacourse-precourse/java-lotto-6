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
            throw new IllegalArgumentException("[ERROR] 구입 금액은 6자리 이하여야 합니다.");
        }
    }

    private void checkMaxPrice(Integer price) {
        if (price > 100000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 100000원 이하여야 합니다.");
        }
    }

    private void checkRest(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private Integer translateToPrice(String refinedReadLine) {
        try {
            return Integer.parseInt(refinedReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력되어야 합니다.");
        }
    }
}
