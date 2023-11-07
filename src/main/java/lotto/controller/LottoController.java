package lotto.controller;

public class LottoController {
    private final InputController inputController = new InputController();

    public Integer getPurchaseQuantity(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
