package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.BonusNumberValidator;
import lotto.validator.WinningNumbersValidator;

public class LottoResultChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private static final WinningNumbersValidator WINNING_NUMBERS_VALIDATOR = new WinningNumbersValidator();
    private static final BonusNumberValidator BONUS_NUMBER_VALIDATOR = new BonusNumberValidator();

    public void createWinningNumbers(String winningNumbers) {
        WINNING_NUMBERS_VALIDATOR.validate(winningNumbers);
        setWinningNumbers(winningNumbers);
    }

    private void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void createBonusNumber(String bonusNumber) {
        BONUS_NUMBER_VALIDATOR.validate(bonusNumber);
        checkBonusNumberDuplicateWinningNumbers(bonusNumber);
        setBonusNumber(bonusNumber);
    }

    private void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void checkBonusNumberDuplicateWinningNumbers(String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> showLottoResults(List<Lotto> lottos) {
        List<Integer> lottoResults = new ArrayList<>(Collections.nCopies(6, 0));
        for(Lotto lotto : lottos) {
            int rank = calculateLottoResult(lotto).getRank();
            int currentValue = lottoResults.get(rank);
            lottoResults.set(rank, currentValue+1);
        }
        return lottoResults;
    }

    private LottoResult calculateLottoResult(Lotto lotto) {
        int matchingWinningNumberCount = countMatchingNumbers(lotto);
        if (matchingWinningNumberCount == 5) {
            if (containsBonusNumber(lotto)) {
                return LottoResult.SECOND_PRIZE;
            }
            return LottoResult.THIRD_PRIZE;
        }
        return determineRank(matchingWinningNumberCount);
    }

    private int countMatchingNumbers(Lotto lotto) {
        int matchingWinningNumberCount = 0;
        for(int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                matchingWinningNumberCount++;
            }
        }
        return matchingWinningNumberCount;
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private LottoResult determineRank(int matchingWinningNumberCount) {
        if (matchingWinningNumberCount == 6) {
            return LottoResult.FIRST_PRIZE;
        }
        if (matchingWinningNumberCount == 4) {
            return LottoResult.FORTH_PRIZE;
        }
        if (matchingWinningNumberCount == 3) {
            return LottoResult.FIFTH_PRIZE;
        }
        return LottoResult.NO_PRIZE;
    }
}
