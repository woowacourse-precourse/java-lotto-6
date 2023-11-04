package lotto.Domain;

import static lotto.Validator.InputValidator.checkCommaDelimiter;
import static lotto.Validator.InputValidator.checkDistinctBetweenWinningAndBonusNumber;
import static lotto.Validator.InputValidator.checkDistinctNumbers;
import static lotto.Validator.InputValidator.checkSixNumber;
import static lotto.Validator.InputValidator.isEmpty;
import static lotto.Validator.InputValidator.isNumber;
import static lotto.Validator.InputValidator.isValidRangeNumber;

public class LottoSystem {
    private String lottoWinningNumber;
    private String lottoBonusNumber;
    public LottoSystem(String lottoWinningNumber, String lottoBonusNumber){
        if(isEmpty(lottoWinningNumber) && isNumber(lottoWinningNumber) && isValidRangeNumber(lottoWinningNumber)) {
            checkCommaDelimiter(lottoWinningNumber);
            checkSixNumber(lottoWinningNumber);
            checkDistinctNumbers(lottoWinningNumber);
            this.lottoWinningNumber = lottoWinningNumber;
        }
        if(isEmpty(lottoBonusNumber) && isNumber(lottoBonusNumber) && isValidRangeNumber(lottoBonusNumber)){
            checkDistinctBetweenWinningAndBonusNumber(lottoWinningNumber, lottoBonusNumber);
            this.lottoBonusNumber = lottoBonusNumber;
        }
    }
}
