package lotto.dto;

public class Money {
    private final int money;

    public Money(int input) {
        checkValidateInput(input);
        this.money = input;
    }

    private void checkValidateInput(int input) {
        inputZero(input);
        inputDivisible(input);
    }

    private void inputZero(int input) {
        if ( input == 0 ) throw new IllegalArgumentException("[ERROR] 구매 금액이 0보다 커야합니다. ");
    }

    private void inputDivisible(int input) {
        if ( input % 1000 != 0 ) throw new IllegalArgumentException("[ERROR] 1000단위의 금액을 입력해야합니다.");
    }

    public int ticket() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
