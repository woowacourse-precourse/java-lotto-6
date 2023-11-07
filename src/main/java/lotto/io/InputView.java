package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionManager;

public class InputView {

    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_WRONG_NUMBER_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String ERROR_WRONG_SPRIT_MESSAGE = "번호는 쉼표(,)를 기준으로 구분합니다. ex) 1,2,3";

    private final IoManager ioManager;

    public InputView(IoManager ioManager) {
        this.ioManager = ioManager;
    }

    public int inputMoney() {
        System.out.println(PROMPT_MONEY);
        return stringToInt(ioManager.read());
    }

    public List<Integer> inputLotto() {
        displayEmptyLine();
        System.out.println(PROMPT_WINNING_NUMBERS);
        List<Integer> lottoNumbers = getSplitByComma(ioManager.read());
        return lottoNumbers;
    }

    private List<Integer> getSplitByComma(String input) {
        validateSplitByComma(input);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : input.split(",")) {
            lottoNumbers.add(stringToInt(str));
        }
        return lottoNumbers;
    }

    private void validateSplitByComma(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',') {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    ERROR_WRONG_SPRIT_MESSAGE);
        }
    }

    public int inputBonus() {
        displayEmptyLine();
        System.out.println(PROMPT_BONUS_NUMBER);
        return stringToInt(ioManager.read());
    }

    private int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    ERROR_WRONG_NUMBER_MESSAGE);
        }
    }

    private void displayEmptyLine() {
        System.out.println();
    }
}
