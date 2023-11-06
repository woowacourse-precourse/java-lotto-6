package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private void validateStringToNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.NOT_INT_NUMBER_ERROR);
        }
    }

    private void validateLottoNumberRange(Integer number) {
        if (number < Constants.MIN_LOTTO_NUM || number > Constants.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Constants.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public Integer getPrice() {
        while (true) {
            System.out.println(Constants.GET_PRICE_MESSAGE);
            String price = Console.readLine();

            try {
                validateStringToNumber(price);
                validatePriceInput(price);

                return Integer.parseInt(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePriceInput(String price) {
        if (Integer.parseInt(price) % Constants.PRICE_UNIT != 0) {
            throw new IllegalArgumentException(Constants.NOT_UNIT_PRICE_ERROR);
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
            validateStringToNumber(number);
            validateLottoNumberRange(Integer.parseInt(number));
        }
    }

    public Integer getBonusNumber(Lotto winningNumber) {
        while (true) {
            System.out.println(Constants.GET_BONUS_NUMBER_MESSAGE);
            String bonusNumber = Console.readLine();

            try {
                validateStringToNumber(bonusNumber);
                validateLottoNumberRange(Integer.parseInt(bonusNumber));
                validateBonusNumberInput(Integer.parseInt(bonusNumber), winningNumber);

                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumberInput(Integer bonusNumber, Lotto winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.DUPLICATE_NUMBER_ERROR);
        }
    }
}
