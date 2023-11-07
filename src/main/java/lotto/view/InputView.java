package lotto.view;

import java.util.Arrays;
import java.util.List;

public abstract class InputView {
    protected abstract String read();

    protected abstract void println(final String text);

    public int getInputMoney() {
        println("구입금액을 입력해 주세요.");
        final String input = read();
        return convertStringToInt(input);
    }

    private int convertStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.", e);
        }
    }

    public List<Integer> getWinningNumbers() {
        println("당첨 번호를 입력해 주세요.");
        final String input = read();
        return convertStringToIntegers(input);
    }

    private List<Integer> convertStringToIntegers(final String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("쉼표로 구분된 정수만 입력할 수 있습니다.", e);
        }
    }
}
