package lotto.view;

import java.util.List;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int inputBuyingPrice() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return InputNumberReader.readNumber();
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return InputNumberReader.readNumbers(DELIMITER);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return InputNumberReader.readNumber();
    }
}
