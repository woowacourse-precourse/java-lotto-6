package lotto.domain.lotto;

import lotto.global.converter.NumberConverter;
import lotto.global.constant.BonusNumberMatch;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<WinningNumber> winningNormalNumbers;
    private WinningNumber bonusNumber;

    public WinningNumbers() {
        this.winningNormalNumbers = new ArrayList<>();
    }

    public void generateWinningNormalNumbers(String inputNumbers) {
        List<Integer> numbers = NumberConverter.convertToNumbers(inputNumbers);
        for (Integer number : numbers) {
            WinningNumber winningNumber = new WinningNumber(number);
            validateDuplicateNumber(winningNumber);
            winningNormalNumbers.add(winningNumber);
        }
        validateNumberOfWinningNormalNumberIsSix();
    }

    public void generateBonusNumber(String inputNumber) {
        Integer number = NumberConverter.convertToNumber(inputNumber);
        bonusNumber = new WinningNumber(number);
        validateDuplicateNumber(bonusNumber);
    }



    private void validateDuplicateNumber(WinningNumber winningNumber) {
        for (WinningNumber winningNormalNumber : winningNormalNumbers) {
            if(winningNormalNumber.equals(winningNumber)) {
                throw new IllegalArgumentException("중복 x");
            }
        }
    }

    private void validateNumberOfWinningNormalNumberIsSix() {
        if(winningNormalNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 숫자 개수는 6개");
        }
    }

    public int compareWinningNormalNumberWithLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;

        for (WinningNumber winningNormalNumber : winningNormalNumbers) {
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

    public BonusNumberMatch compareBonusNumberWithLotto(Lotto lotto, int matchCount) {
        if(matchCount != 5) {
            return BonusNumberMatch.NOT_MATTER;
        }
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer lottoNumber : lottoNumbers) {
            if(bonusNumber.isEqualsToLottoNumber(lottoNumber) ) {
                return BonusNumberMatch.MATCH;
            }
        }
        return BonusNumberMatch.NOT_MATCH;
    }

    public List<WinningNumber> getWinningNormalNumbers() {
        return winningNormalNumbers;
    }

    public WinningNumber getBonusNumber() {
        return bonusNumber;
    }
}
