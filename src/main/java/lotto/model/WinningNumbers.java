package lotto.model;

import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.constans.WinningPrize;
import lotto.validator.BonusNumberValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumbersValidator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusNumber;
    private static final Validator WINNING_NUMBERS_VALIDATOR = new WinningNumbersValidator();
    private static final Validator BONUS_NUMBER_VALIDATOR = new BonusNumberValidator();

    private WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private static List<Integer> splitNumbers(String numbers) {
        return Arrays.stream(numbers.split(NUMBER_SEPARATOR.pattern()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

        public static WinningNumbers from(String winningNumbers) {
        WINNING_NUMBERS_VALIDATOR.validate(winningNumbers);
        return new WinningNumbers(splitNumbers(winningNumbers));
    }

    public void createBonusNumber(String bonusNumber) {
        BONUS_NUMBER_VALIDATOR.validate(bonusNumber);
        checkBonusNumberDuplicateWinningNumbers(bonusNumber);
        setBonusNumber(bonusNumber);
    }

    private void checkBonusNumberDuplicateWinningNumbers(String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATES_WINNING_NUMBER_ERROR.message());
        }
    }

    private void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> calculateLottosResult(List<Lotto> lottos) {
        List<Integer> lottoResults = new ArrayList<>(Collections.nCopies(WinningPrize.values().length, 0));
        for (Lotto lotto : lottos) {
            int prizeRank = calculatePrizeRank(lotto);
            int currentValue = lottoResults.get(prizeRank);
            lottoResults.set(prizeRank, currentValue + 1);
        }
        return lottoResults;
    }

    private int calculatePrizeRank(Lotto lotto) {
        int matchingNumberCount = countMatchingNumbers(lotto);
        boolean matchBonusNumber = matchBonusNumber(lotto);
        return WinningPrize.getRankByResult(matchingNumberCount, matchBonusNumber);
    }

    private int countMatchingNumbers(Lotto lotto) {
        int matchingNumberCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
