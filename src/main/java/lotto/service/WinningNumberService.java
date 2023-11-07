package lotto.service;

import java.util.List;
import lotto.model.domain.WinningLotto;
import lotto.model.domain.WinningLottoValidator;

public class WinningNumberService {

    private final WinningLottoValidator validator = new WinningLottoValidator();

    public WinningLotto getWinningNumberIfValid(String winningNumbers) {
        try {
            List<String> inputDividedByComma = validator.validateDelimiterComma(winningNumbers);
            validator.validateSixElements(inputDividedByComma);
            List<Integer> integerNumbers = validator.validateWinningNumberIsNumeric(inputDividedByComma);
            validator.validateNumberBetweenInRange(integerNumbers);
            return new WinningLotto(integerNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
