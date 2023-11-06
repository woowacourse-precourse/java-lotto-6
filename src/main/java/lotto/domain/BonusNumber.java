package lotto.domain;

public class BonusNumber {

    private final int number;

    public BonusNumber(String number) {
        validateNumber(number);
        validateRange(number);
        this.number = Integer.parseInt(number);
    }

    private static void validateNumber(String number){
        try {
            int num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    private static void validateRange(String number) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

    public int getNumber() {
        return number;
    }
}
