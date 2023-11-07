package lotto.domain.lotto;

import lotto.global.converter.NumberConverter;

import java.util.ArrayList;
import java.util.List;

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
                throw new IllegalArgumentException("중복 x");
            }
        }
    }

    private void validateNumberOfWinningNormalNumberIsSix() {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자 개수는 6개");
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
                throw new IllegalArgumentException("보너스 숫자 중복");
            }
        }
    }
}
