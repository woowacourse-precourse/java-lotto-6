package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String input = input("구입금액을 입력해 주세요.");
        validateIsNumber(input);
        int purchaseAmount = Integer.parseInt(input);
        validateIsPositiveNumber(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> inputWinningNumber() {
        String input = input("당첨 번호를 입력해 주세요.");
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String input = input("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateIsPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력해주세요.");
        }
    }
}
