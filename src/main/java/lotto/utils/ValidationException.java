package lotto.utils;

public class ValidationException {

    public void isNullOrEmpty(String input) {
        if (input == null || input.replaceAll("\\s","").length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }

    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public void isDivideByPriceUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입 금액을 입력해 주세요.");
        }
    }

    public void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    public void isWinningNumbersCountSix() {

    }

    public void isWinningNumbersUnique() {

    }
}
