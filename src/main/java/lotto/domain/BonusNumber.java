package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(String number) {
        // 검증로직
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }
}