package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Validator;

public class InputView {
    private static final String INPUT_BUY_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    public long inputBuyCashFromUser() {
        System.out.println(INPUT_BUY_CASH_MESSAGE);
        return inputNumericValue();
    }

    public long inputBonusNumberFromUser() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputNumericValue();
    }

    private long inputNumericValue() {
        String input = readLine();

        Validator.INSTANCE.numberValidate(input);

        return Long.parseLong(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        List<String> inputNumbers = split(readLine());
        inputNumbers.forEach(Validator.INSTANCE::numberValidate);

        return toIntegerList(inputNumbers);
    }

    private List<String> split(String input) {
        return List.of(input.split(COMMA));
    }

    private List<Integer> toIntegerList(List<String> inputNumbers) {
        return inputNumbers.stream().map(Integer::parseInt).toList();
    }
}
