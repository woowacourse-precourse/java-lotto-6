package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.validator.ErrorMessage.*;

public class LottoNumberValidator {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    void validate(String input) {
        List<String> tokenList = inputToList(input);

        areTokensNumeric(tokenList);
        isLottoNumbersSizeJustified(tokenList);

        List<Integer> numList = tokensToNumList(tokenList);
        areNumbersInRange(numList);
        areNumbersNotDuplicated(numList);
    }

    private void isLottoNumbersSizeJustified(List<String> tokenList) {
        if (tokenList.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_NOT_ENOUGH_MESSAGE);
        }
    }

    private List<Integer> tokensToNumList(List<String> tokenList) {
        List<Integer> numList = new ArrayList<>();
        for (String token : tokenList) {
            int number = Integer.parseInt(token);
            numList.add(number);
        }
        return numList;
    }

    private void areNumbersNotDuplicated(List<Integer> numList) {

        List<Integer> deduplicationList = numList.stream().distinct().toList();

        if (numList.size() != deduplicationList.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_DUPLICATED_MESSAGE);
        }
    }

    private void areNumbersInRange(List<Integer> list) {
        for (int number : list) {
            if (number < MIN_BONUS_NUMBER || MAX_BONUS_NUMBER < number) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_NOT_IN_RANGE_MESSAGE);
            }
        }

    }

    private List<String> inputToList(String input) {
        List<String> asList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            asList.add(tokenizer.nextToken());
        }
        return asList;
    }


    private void areTokensNumeric(List<String> list) {
        for (String token : list) {

            try {
                Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_NOT_NUMERIC_MESSAGE);
            }
        }
    }

}
