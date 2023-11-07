package lotto.domain;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
    private void validate(int money) {
        validateInputZero(money);
        validatePurchaseAmount(money);
    }
    private void validatePurchaseAmount(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void validateInputZero(int money) {
        if (money == 0) {
            System.out.println("[ERROR] 구입 금액은 0보다 커야 합니다.");
            throw new IllegalArgumentException();
        }
    }


}
