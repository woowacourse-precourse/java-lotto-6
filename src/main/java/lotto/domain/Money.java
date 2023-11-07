package lotto.domain;

public class Money {
    private int amount;

    public Money(String input) {
        isNum(input);
        isPositive(input);
        isDividedBy1000(input);
        this.amount = Integer.parseInt(input);
    }

    private void isPositive(String input) {
        int num = Integer.parseInt(input);
        if (num <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요");
        }
    }

    private void isDividedBy1000(String input) {
        int num = Integer.parseInt(input);
        if (num % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수를 입력해주세요");
        }
    }

    private void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
