package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Error;

import java.util.List;

public class InputView {

    private static final String NOTICE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String NOTICE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String DELIMITER_OF_WINNING_NUMBER = ",";
    private static final String FORMAT_OF_NUMERIC = "[0-9]+";

    public int requestPurchasePrice() {
        System.out.println(NOTICE_INPUT_PURCHASE_PRICE);
        String input = Console.readLine();
        validatePurchasePriceType(input);
        validateDividedByLottoPrice(stringToInt(input));
        return stringToInt(input);
    }

    public List<Integer> requestWinningNumber() {
        System.out.println(NOTICE_INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        List<String> inputNumbers = List.of(input.split(DELIMITER_OF_WINNING_NUMBER));
        validateWinningNumbersType(inputNumbers);
        return stringListToIntList(inputNumbers);
    }

    public int requestBonusNumber() {
        System.out.println(NOTICE_INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateBonusNumberType(input);
        return stringToInt(input);
    }

    private List<Integer> stringListToIntList(List<String> before) {
        return before.stream()
                .map(this::stringToInt)
                .toList();
    }

    private void validateWinningNumbersType(List<String> numbers) {
        for (String number : numbers) {
            validateWinningNumberType(number);
        }
    }

    private void validateWinningNumberType(String number) {
        if (isNotNumeric(number)) {
            Error.NOT_NUMERIC_WINNING_NUMBER.throwError();
        }
    }

    private void validateBonusNumberType(String number) {
        if (isNotNumeric(number)) {
            Error.NOT_NUMERIC_BONUS_NUMBER.throwError();
        }
    }

    private void validatePurchasePriceType(String number) {
        if (isNotNumeric(number)) {
            Error.NOT_NUMERIC_PURCHASE_PRICE.throwError();
        }
    }

    private boolean isNotNumeric(String number) {
        return !number.matches(FORMAT_OF_NUMERIC);
    }

    private void validateDividedByLottoPrice(int price) {
        if (isNotDividedByLottoPrice(price)) {
            Error.NOT_DIVIDED_BY_LOTTO_PRICE.throwError();
        }
    }

    private boolean isNotDividedByLottoPrice(int price) {
        return price % ONE_LOTTO_PRICE != 0;
    }

    private int stringToInt(String number) {
        return Integer.parseInt(number);
    }
}
