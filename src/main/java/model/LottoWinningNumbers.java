package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.Converter;
import utils.NumberValidation;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;
    private static final String DELIMITER = ",";
    private static final String DUPLICATION_BONUS_AND_WINNING = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    public LottoWinningNumbers(String winningNumbers, String bonusNumber) {
        this.winningNumbers = stringToLotto(winningNumbers);
        validationBonusNumber(Converter.stringToInt(bonusNumber));
        this.bonusNumber = Converter.stringToInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validationBonusNumber(int bonusNumber) {
        NumberValidation.isOverMaxNumber(bonusNumber);
        NumberValidation.isUnderMinNumber(bonusNumber);
        duplicationBonusNumber(bonusNumber);
    }

    public void duplicationBonusNumber(int bonusNumber){
        if(winningNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATION_BONUS_AND_WINNING);
        }
    }
    public String[] splitByDelimiter(String winningNumbers) {
        return winningNumbers.split(DELIMITER);
    }

    public Lotto stringToLotto(String winningNumbers) {
        return new Lotto(Arrays.stream(splitByDelimiter(winningNumbers)).map(Converter::stringToInt)
                .collect(Collectors.toList()));
    }
}
