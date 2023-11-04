package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningNumber {
    private Lotto lottoNumber;
    public WinningNumber(List<String> inputs) {
        lottoNumber = new Lotto(inputs.stream()
                .map(String::trim)
                .map(this::convertInputToLottoNumber)
                .toList());
    }

    private int convertInputToLottoNumber(String input) {
        validateIsNumber(input);
        validateRange(input);
        return Integer.parseInt(input);
    }
    private void validateIsNumber(String input) {
        if (input.matches("\\d")) return;
        throw new IllegalArgumentException("당첨 번호는 숫자를 입력해주세요.");
    }

    private void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number > 0 && number <= 45) return;
        throw new IllegalArgumentException(("당첨 번호는 1에서 45 숫자를 입력해주세요"));
    }
}
