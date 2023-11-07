package lotto.view;

import static lotto.constant.ErrorMessage.EMPTY;
import static lotto.constant.ErrorMessage.INPUT_STRING;
import static lotto.constant.LottoNumberMessage.ASK_BONUS_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoNumberMessage;


public class BonusNumberView {

    public int bonusNumber() {

        BonusNumberMessage(ASK_BONUS_NUMBER);
        String input = inputBonusNumber();
        validateBonusNumber(input);
        return conversion(input);
    }

    private String inputBonusNumber() {
        return Console.readLine();
    }

    private void BonusNumberMessage(LottoNumberMessage lottoNumberMessage) {
        System.out.println(lottoNumberMessage.getMessage());

    }

    private void validateBonusNumber(String input) {
        validateNotNull(input);
        validateNotNumber(input);
    }

    private void validateNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_STRING.getMessage());
        }
    }

    private void validateNotNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY.getMessage());
        }
    }

    private int conversion(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

}
