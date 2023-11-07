package lotto.model;

public class PurchasePrice {
    private static final int ONE_LOTTO_PRICE = 1000;
    private int price;

    public PurchasePrice(String price) {
        validateNumber(price);
        validateCondition(price);
        this.price = Integer.parseInt(price);
    }

    private void validateNumber(String price) {
        int amount;
        try {
            amount = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
    }

    private void validateCondition(String price) {
        int amount = Integer.parseInt(price);
        if (amount % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력은 1000원 단위로만 가능합니다");
        }
    }

    public int getPrice() {
        return price;
    }

    public int countPurchasedLottos() {
        return price/ONE_LOTTO_PRICE;
    }
}
