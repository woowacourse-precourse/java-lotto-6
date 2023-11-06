package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionManager;

public class InputView {

    private final IoManager ioManager;

    private static final String PROMPT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "숫자를 입력해야 합니다.";

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
        String[] input = ioManager.read().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : input) {
            lottoNumbers.add(stringToInt(str));
        }
        return lottoNumbers;
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
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void displayEmptyLine() {
        System.out.println();
    }
}
