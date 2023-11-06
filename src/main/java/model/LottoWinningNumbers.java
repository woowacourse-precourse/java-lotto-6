package model;

import java.util.Arrays;
import java.util.stream.Collectors;
import utils.Converter;
import utils.NumberValidation;

public class LottoWinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;
    private static final String DELIMITER = ",";

    public LottoWinningNumbers(String winningNumbers, String bonusNumber) {
        this.winningNumbers = stringToLotto(winningNumbers);
        validationBonusNumber(Converter.stringToInt(bonusNumber));
        this.bonusNumber = Converter.stringToInt(bonusNumber);
    }

    public void validationBonusNumber(int bonusNumber) {
        NumberValidation.isOverMaxNumber(bonusNumber);
        NumberValidation.isUnderMinNumber(bonusNumber);
    }

    public String[] splitByDelimiter(String winningNumbers) {
        return winningNumbers.split(DELIMITER);
    }

    public Lotto stringToLotto(String winningNumbers) {
        return new Lotto(Arrays.stream(splitByDelimiter(winningNumbers)).map(Converter::stringToInt)
                .collect(Collectors.toList()));
    }
}
