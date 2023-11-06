package lotto.domain;

public class BonusNumber {

    private final int number;

    public BonusNumber(String number) {
        int safeNumber = validate(number);
        this.number = safeNumber;
    }

    private static int validate(String number) {

        // 입력값이 숫자인지

        // 입력값이 0이하거나 45초과일 경우

        // 보너스 번호가 사용자 선택 번호와 중복일 경우

        return Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }
}
