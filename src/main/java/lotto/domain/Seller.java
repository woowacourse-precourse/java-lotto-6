package lotto.domain;

public class Seller {
    private static final Integer UNIT = 1000;
    public static Integer numberOfLotto(Integer price) {
        return price / UNIT;
    }
}
