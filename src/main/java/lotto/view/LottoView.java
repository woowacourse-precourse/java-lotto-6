package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class LottoView {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String input = input("구입금액을 입력해 주세요.");
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
