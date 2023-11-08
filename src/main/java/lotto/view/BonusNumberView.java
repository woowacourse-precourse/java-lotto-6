package lotto.view;

import static lotto.constant.ErrorMessage.EMPTY;
import static lotto.constant.ErrorMessage.INPUT_STRING;
import static lotto.constant.LottoNumberMessage.ASK_BONUS_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoNumberMessage;


public class BonusNumberView {

    public int requestAndValidateBonusNumber() {

        printBonusNumberMessage(ASK_BONUS_NUMBER);
        String input = readBonusNumberInput();
        validateBonusNumber(input);
        return convertToNumber(input);
    }

    private String readBonusNumberInput() {
        return Console.readLine();
    }

    private void printBonusNumberMessage(LottoNumberMessage lottoNumberMessage) {
        System.out.println(lottoNumberMessage.getMessage());

    }

    private void validateBonusNumber(String input) {
        checkNull(input);
        checkNumber(input);
    }

    private void checkNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_STRING.getMessage());
        }
    }

    private void checkNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY.getMessage());
        }
    }

    private int convertToNumber(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

}
