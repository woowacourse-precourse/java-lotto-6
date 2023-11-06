package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public Integer getPrice() {
        while (true) {
            System.out.println(Constants.GET_PRICE_MESSAGE);
            String price = Console.readLine();

            try {
                validatePriceInput(price);
                return Integer.parseInt(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePriceInput(String price) {
        try {
            int convertPrice = Integer.parseInt(price);
            if (convertPrice % Constants.PRICE_UNIT != 0) {
                throw new IllegalArgumentException(Constants.NOT_UNIT_PRICE_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.NOT_INT_PRICE_ERROR);
        }
    }

    public Lotto getWinningNumber() {
        while (true) {
            System.out.println(Constants.GET_WINNING_NUMBER_MESSAGE);
            String winningNumber = Console.readLine();

            try {
                validateWinningNumberInput(winningNumber);

                List<Integer> numbers = Arrays.stream(winningNumber.split(","))
                        .map(Integer::parseInt)
                        .toList();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumberInput(String winningNumber) {
        List<String> numbers = List.of(winningNumber.split(","));

        if (numbers.size() != Constants.LOTTO_LENGTH) {
            throw new IllegalArgumentException(Constants.LOTTO_LENGTH_ERROR);
        }

        for (String number: numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Constants.NOT_INT_NUMBER_ERROR);
            }
        }
    }
}
