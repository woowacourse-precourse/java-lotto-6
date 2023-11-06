package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.input.InputCommonValidator;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int inputBuyingPrice() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String inputPrice = readLine().trim();
        InputCommonValidator.validateSingle(inputPrice);
        return Integer.parseInt(inputPrice);
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        List<String> inputNumbers = Arrays.stream(readLine().split(DELIMITER))
                .map(String::trim)
                .toList();
        InputCommonValidator.validateMultiple(inputNumbers);
        return convertToNumbers(inputNumbers);
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String number = readLine();
        InputCommonValidator.validateSingle(number);
        return Integer.parseInt(number);
    }

    private List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private String readLine() {
        return Console.readLine();
    }
}
