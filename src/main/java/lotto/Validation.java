package lotto;

public class Validation {
    public void isAllNumber(String string) {
        if (!string.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
        }
    }

    public void isDivisibleByThousand(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
