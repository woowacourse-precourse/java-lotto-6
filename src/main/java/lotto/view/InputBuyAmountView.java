package lotto.view;

public class InputBuyAmountView extends InputView {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer getInputValue() {
        System.out.println(INPUT_MESSAGE);
        String result = inputValue();
        System.out.println();
        isDigitValidate(result);
        beDividedThousandValidate(result);
        isNotZeroValidate(result);
        return Integer.parseInt(result);
    }
}
