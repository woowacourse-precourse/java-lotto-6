package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.input.Input;
import lotto.output.Output;

public class GameController {

    public int getPurchaseAmount() {
        Output.printPurchaseAmountInputMessage();
        try {
            return Input.getInteger();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getLottoNumbers() {
        Output.printLottoNumbersInputMessage();
        try {
            String readLine = Input.getLine();
            return Arrays.stream(readLine.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage("[ERROR] 정수와 쉼표만 입력해야 합니다.");
            return getLottoNumbers();
        }
    }

    public int getBonusLottoNumber() {
        Output.printBonusLottoNumbersInputMessage();
        try {
            return Input.getInteger();
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getBonusLottoNumber();
        }
    }
}
