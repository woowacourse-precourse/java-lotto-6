package lotto.model;

import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.AppConfig;
import lotto.model.constans.WinningRank;
import lotto.validator.Validator;

public class WinningNumbers {
    private static final AppConfig appConfig = new AppConfig();
    private static final Validator WINNING_NUMBERS_VALIDATOR = appConfig.winningNumbersValidator();
    private static final Validator BONUS_NUMBER_VALIDATOR = appConfig.bonusNumberValidator();
    private final List<Integer> winningNumbers;
    private int bonusNumber;

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

    public LottosResult calculateLottosResult(List<Lotto> lottos) {
        LottosResult lottosResult = LottosResult.create();
        for (Lotto lotto : lottos) {
            lottosResult.updateResult(calculateWinningRank(lotto));
        }
        return lottosResult;
    }

    private WinningRank calculateWinningRank(Lotto lotto) {
        int matchingNumberCount = countMatchingNumbers(lotto);
        boolean matchBonusNumber = matchBonusNumber(lotto);
        return WinningRank.getWinningPrizeByResult(matchingNumberCount, matchBonusNumber);
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
