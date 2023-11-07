package lotto.domain.lotto;

import lotto.global.converter.NumberConverter;

import java.util.ArrayList;
import java.util.List;

import static lotto.global.constant.exception.ExceptionMessage.*;

public class WinningNormalNumbers {
    private List<WinningNumber> winningNumbers;

    public WinningNormalNumbers() {
        this.winningNumbers = new ArrayList<>();
    }

    public void generateWinningNormalNumbers(String inputNumbers) {
        winningNumbers.clear();

        List<Integer> numbers = NumberConverter.convertToNumbers(inputNumbers);
        for (Integer number : numbers) {
            WinningNumber winningNumber = new WinningNumber(number);
            validateDuplicateNumber(winningNumber);
            winningNumbers.add(winningNumber);
        }
        validateNumberOfWinningNormalNumberIsSix();
    }

    private void validateDuplicateNumber(WinningNumber winningNumber) {
        for (WinningNumber winningNormalNumber : winningNumbers) {
            if(winningNormalNumber.equals(winningNumber)) {
                throw new IllegalArgumentException(NUMBERS_DUPLICATED.getMessage());
            }
        }
    }

    private void validateNumberOfWinningNormalNumberIsSix() {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_COUNT_MUST_BE_SIX.getMessage());
        }
    }

    public int compareWinningNormalNumberWithLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;

        for (WinningNumber winningNormalNumber : winningNumbers) {
            for (Integer lottoNumber : lottoNumbers) {
                matchCount = getMatchCount(matchCount, winningNormalNumber, lottoNumber);
            }
        }
        return matchCount;
    }

    private int getMatchCount(int matchCount, WinningNumber winningNormalNumber, Integer lottoNumber) {
        if(winningNormalNumber.isEqualsToLottoNumber(lottoNumber)) {
            matchCount += 1;
        }
        return matchCount;
    }

    public void validateBonusIsDuplicateWithWinningNormalNumber(BonusNumber bonusNumber) {
        for (WinningNumber number : winningNumbers) {
            if(number.equals(bonusNumber.getBonusNumber())) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED.getMessage());
            }
        }
    }
}
