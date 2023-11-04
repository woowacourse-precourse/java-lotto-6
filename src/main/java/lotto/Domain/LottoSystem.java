package lotto.Domain;

import static lotto.Validator.InputValidator.checkCommaDelimiter;
import static lotto.Validator.InputValidator.checkSixNumber;
import static lotto.Validator.InputValidator.isNumber;
import static lotto.Validator.InputValidator.isValidRangeNumber;

public class LottoSystem {
    private String lottoWinningNumber;
    private String lottoBonusNumber;
    public LottoSystem(String lottoWinningNumber, String lottoBonusNumber){
        if(isNumber(lottoWinningNumber) && isValidRangeNumber(lottoWinningNumber)) {
            checkCommaDelimiter(lottoWinningNumber);
            checkSixNumber(lottoWinningNumber);
        }
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
    }
}
