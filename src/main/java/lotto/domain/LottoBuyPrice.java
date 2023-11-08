package lotto.domain;

public class LottoBuyPrice {
    private Integer buyPrice;

    public static Integer verificationPrice(String price) {
        Integer buyPrice = checkNumber(price);
        checkLottoBuy(buyPrice);

        return buyPrice;
    }

    public static Integer getBuyLottoCnt(Integer buyPrice) {
        return buyPrice / 1000;
    }

    private static Integer checkNumber(String price) {
        try {
            return Integer.valueOf(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLottoBuy(Integer buyPrice) {
        if (buyPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
