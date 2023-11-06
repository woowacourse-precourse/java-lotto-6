package lotto.domain;

public class Buy {
    private final Integer money;
    private final Integer count;

    public Buy(Integer money) {
        validateMoney(money);
        this.money = money;
        this.count = findCount(money);
    }

    private void validateMoney(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    private Integer findCount(Integer money) {
        return money / 1000;
    }

    public Integer getCount() {
        return count;
    }
}
