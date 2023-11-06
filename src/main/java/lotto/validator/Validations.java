package lotto.validator;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static lotto.enums.RegexCollections.REGEX_FOR_INPUT_LOTTO_PAYMENT;
import static lotto.enums.RegexCollections.REGEX_FOR_LOTTO_NUMBER_RANGE;

public class Validations {
    private static final Validations singleton = new Validations();

    private Validations() {
    }

    public static Validations getInstance() {
        return singleton;
    }

    public int validateEnteredLottoPayment(String desiredPurchaseAmount) throws IllegalArgumentException {
        if (Pattern.matches(REGEX_FOR_INPUT_LOTTO_PAYMENT.getRegex(), desiredPurchaseAmount) &&
                desiredPurchaseAmount.length() >= 4 &&
                desiredPurchaseAmount.endsWith("000")) {
            return Integer.parseInt(desiredPurchaseAmount);
        }
        throw new IllegalArgumentException();
    }

    public List<Integer> validateEnteredLottoNumbers(String lottoWinningNumbers) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        Set<String> numberChecker = new HashSet<>();

        Stream.of(lottoWinningNumbers.split(","))
                .iterator()
                .forEachRemaining(number -> {
                    if (!Pattern.matches(REGEX_FOR_LOTTO_NUMBER_RANGE.getRegex(), number.trim()) ||
                    numberChecker.contains(number.trim()))
                        throw new IllegalArgumentException();
                    numberChecker.add(number.trim());
                    numbers.add(Integer.parseInt(number.trim()));
                });
        return numbers;
    }

    public int validateEnteredBonusNumber(List<Integer> lottoWinningNumbers, String input) throws IllegalArgumentException {
        if (Pattern.matches(REGEX_FOR_LOTTO_NUMBER_RANGE.getRegex(), input.trim()) &&
                !lottoWinningNumbers.contains(Integer.parseInt(input.trim()))) {
            return Integer.parseInt(input.trim());
        }
        throw new IllegalArgumentException();
    }
}
