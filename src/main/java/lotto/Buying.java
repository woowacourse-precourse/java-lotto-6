package lotto;

public class Buying extends Input {
    private Integer price;

    public Buying() {
        this.price = 0;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getBuyingCount() {
        return this.price / 1000;
    }

    public void save(String readLine) {
        Integer price = validate(readLine);
        this.price = price;
    }

    protected Integer validate(String readLine) {
        String noEmptyReadLine = removeEmpty(readLine);
        checkDigit(noEmptyReadLine);
        Integer price = translateToValueType(noEmptyReadLine);
        checkBoundary(price);
        checkRest(price);
        return price;
    }

    protected String removeEmpty(String readLine) {
        return readLine.replaceAll("\\s", "");
    }

    private void checkDigit(String readLine) {
        if (readLine.length() > 6) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 6자리 이하여야 합니다.");
        }
    }

    protected Integer translateToValueType(String noEmptyReadLine) {
        try {
            return Integer.parseInt(noEmptyReadLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력되어야 합니다.");
        }
    }

    @Override
    protected void checkBoundary(Integer price) {
        if (price < 1000 || price > 100000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상, 100000원 이하여야 합니다.");
        }
    }

    private void checkRest(Integer price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
