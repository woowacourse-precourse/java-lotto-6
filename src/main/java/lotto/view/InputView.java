package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Bonus;
import lotto.model.Error;
import lotto.model.Lotto;

import java.util.List;

public class InputView {

    private static final String NOTICE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String NOTICE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final String FORMAT_OF_NUMERIC = "[0-9]+";

    public int requestPurchasePrice() {
        System.out.println(NOTICE_INPUT_PURCHASE_PRICE);
        while (true) {
            String input = Console.readLine();
            try {
                validatePurchasePriceType(input);
                validateDividedByLottoPrice(stringToInt(input));
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                continue;
            }
            System.out.println();
            return stringToInt(input);
        }
    }

    public void requestWinningNumber() {
        System.out.println(NOTICE_INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        List<String> inputNumbers = List.of(input.split(DELIMITER));
        try {
            validateWinningNumbersType(inputNumbers);
            List<Integer> winningNumbers = stringListToIntList(inputNumbers);
            Lotto winningLotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            requestWinningNumber();
        }
        System.out.println();
    }

    public void requestBonusNumber() {
        System.out.println(NOTICE_INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        try {
            validateBonusNumberType(input);
            int bonusNumber = stringToInt(input);
            Bonus bonus = new Bonus(bonusNumber);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            requestBonusNumber();
        }
        System.out.println();
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
