package lotto.domain;

public class Validator {

    private Validator() {
        throw new IllegalStateException("");
    }
    public static void validatePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    public static void validateNumbers(String input) {
        String[] numberStrings = input.replace(" ", "").split(",");
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개가 입력돼야 합니다.");
        }
        for (String numberString : numberStrings) {
            if (!numberString.matches("^\\d+$")) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자를 입력해야 합니다.");
            }
            validateLottoNumber(numberString);
        }
    }

    public static void validateLottoNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자를 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자를 입력해야 합니다.");
        }
    }
}