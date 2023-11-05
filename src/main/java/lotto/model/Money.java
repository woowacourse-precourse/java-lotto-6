package lotto.model;

public class Money {
    private int money;

    public Money(int inputMoney) {
        validateInputMoney(inputMoney);
        this.money = inputMoney;
    }

    private void validateInputMoney(int inputMoney) {
        validateMinAmount(inputMoney);
        validateMaxAmount(inputMoney);
        validateDivisible(inputMoney);
    }

    public int calculateLottoCount() {
        return money / 1000;
    }

    private void validateMinAmount(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException("최소 1000원을 입력해야합니다.");
        }
    }

    private void validateMaxAmount(int inputMoney) {
        if (inputMoney > 100_000_000) {
            throw new IllegalArgumentException("최대 100,000,000원을 입력해야합니다.");
        }
    }

    private void validateDivisible(int inputMoney) {
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위의 값을 입력해야합니다.");
        }
    }
}