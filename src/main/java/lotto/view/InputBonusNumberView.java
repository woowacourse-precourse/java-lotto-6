package lotto.view;

public class InputBonusNumberView extends InputView{
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getInputValue() {
        System.out.println(INPUT_MESSAGE);
        String result = inputValue();
        System.out.println();
        isDigitValidate(result);
        return Integer.parseInt(result);
    }
}
