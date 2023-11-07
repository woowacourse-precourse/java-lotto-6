package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.message.ErrorMessage;

public class InputValidator {

    private static final int MINIMUM_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;

    public int validateInputPrice(String inputPrice) {
        int price;
        price = checkNumber(inputPrice);
        price = checkMinPrice(price);
        price = checkPrice(price);

        return price;
    }

    private int checkNumber(String userInput) {
        int userInputNumber;

        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_NUMBER_RANGE.getErrorMessage());
        }

        return userInputNumber;
    }

    private int checkMinPrice(int price) {
        if (price >= MINIMUM_PRICE) {
            return price;
        }
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_MORE_THAN_MINIMUM_PRICE.getErrorMessage());
        }

        return price;
    }

    private int checkPrice(int price) {
        if (price % MINIMUM_PRICE == 0) {
            return price;
        }
        if (price % MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_PRICE_STANDARD.getErrorMessage());
        }

        return price;
    }

    public int validateInputBonusNumber(String inputBonusNumber) {
        int bonusNumber;
        bonusNumber = checkNumber(inputBonusNumber);
        checkNumberRange(bonusNumber);

        return bonusNumber;
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber >= LOTTO_RANGE_START && bonusNumber <= LOTTO_RANGE_END) {
            return;
        }
        if (bonusNumber < LOTTO_RANGE_START || bonusNumber > LOTTO_RANGE_END) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_NUMBER_RANGE.getErrorMessage());
        }
    }

    public List<Integer> validateInputWinnerLotto(String input) {
        checkSplit(input);
        List<Integer> winnerLotto = getIntList(input);
        checkListNumberRange(winnerLotto);

        return winnerLotto;
    }

    private List<Integer> getIntList(String input) {
        List<Integer> winnerLotto = new ArrayList<>();
        int[] inputWinner;
        try {
            inputWinner = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
            winnerLotto = Arrays.stream(inputWinner).boxed()
                .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_INT_LIST.getErrorMessage());
        }
        return winnerLotto;
    }

    private void checkSplit(String userInput) {
        if (!userInput.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_DELIMITER.getErrorMessage());
        }
    }

    private void checkListNumberRange(List<Integer> winnerLotto) {
        for (int index = 0; index < winnerLotto.size(); index++) {
            checkNumberRange(winnerLotto.get(index));
        }
    }
}
