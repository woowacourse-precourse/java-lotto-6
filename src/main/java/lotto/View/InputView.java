package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InputView {

    private static final String PURCHASE_SUM_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static Integer inputPurchaseSum() {
        OutputView.printInputMessage(PURCHASE_SUM_INPUT_MESSAGE);
        String input = Console.readLine();

        try {
            checkInputPurchaseSumValid(input);
            return Integer.parseInt(input);

        } catch ( IllegalArgumentException e ) {
            InputView.inputPurchaseSum();
        }

        return null;
    }

    private static void checkInputPurchaseSumValid(String input) {
        Validation.checkNotNumber(input);
        Validation.checkNotInteger(input);
        Validation.checkNotDivided(input);
    }

    public static List<Integer> inputWinningNumber() {
        OutputView.printInputMessage(WINNING_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        try {
            List<Integer> result = checkInputWinningNumberValid(input);
            return result;

        } catch ( IllegalArgumentException e ) {
            InputView.inputWinningNumber();
        }
        return null;
    }

    private static List<Integer> checkInputWinningNumberValid(String input) {
        Validation.checkNotBlank(input);
        List<String> inputStrings = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();

        Collections.addAll(inputStrings, input.split(","));
        Validation.checkLength(inputStrings);

        for( String str : inputStrings ) {
            Validation.checkNotNumber(str);
            Validation.checkNotInteger(str);
            Integer number = Integer.parseInt(str);
            Validation.checkNotInLottoRange(number);
            winningNumbers.add(number);
        }

        Validation.checkWinningNumbersDuplication(winningNumbers);

        return winningNumbers;
    }

    public static Integer inputBonusNumber(List<Integer> winningNumbers) {
        OutputView.printInputMessage(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        try {
            checkInputBonusNumberValid(input, winningNumbers);
            return Integer.parseInt(input);

        } catch ( IllegalArgumentException e ) {
            InputView.inputBonusNumber(winningNumbers);
        }

        return null;
    }

    private static void checkInputBonusNumberValid(String input, List<Integer> winningNumbers) {
        Validation.checkNotBlank(input);
        Validation.checkNotNumber(input);
        Validation.checkNotInteger(input);

        Integer number = Integer.parseInt(input);
        Validation.checkNotInLottoRange(number);
        Validation.checkBonusNumberDuplication(number, winningNumbers);
    }
}
