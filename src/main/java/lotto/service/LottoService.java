package lotto.service;

public class LottoService {

    public void validateIsNumeric(String inputValue) {
        final String NUMBER_REGEX = "^[\\d]*$";
        if (!inputValue.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    public void validateHasCorrectUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력하세요.");
        }
    }
}
