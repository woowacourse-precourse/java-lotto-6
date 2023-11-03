package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.common.config.UserRule;
import lotto.model.validator.LottoCostValidator;
import lotto.model.validator.LottoNumbersValidator;

public class LottoGameManager {

    public LottoGameManager() {
    }

    public Integer parsingLottoCost(String userInputLottoCost) {
        LottoCostValidator.validateBlank(userInputLottoCost);
        LottoCostValidator.validateNumeric(userInputLottoCost);
        LottoCostValidator.validateThousandUnit(userInputLottoCost);
        return Integer.parseInt(userInputLottoCost);
    }

    public List<String> splitWinningNumbers(String userInputWinningNumbers) {
        return List.of(userInputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.value()));
    }

    public List<Integer> parsingWinningNumbers(String userInputWinningNumbers) {
        List<Integer> parsedWinningNumbers = new ArrayList<>();
        for (String lottoNumber : splitWinningNumbers(userInputWinningNumbers)) {
            LottoNumbersValidator.validateBlank(lottoNumber);
            LottoNumbersValidator.validateNumeric(lottoNumber);
            Integer parsedNumber = Integer.parseInt(lottoNumber.trim());
            LottoNumbersValidator.validateLottoNumberRange(parsedNumber);
            parsedWinningNumbers.add(parsedNumber);
        }
        return parsedWinningNumbers;
    }

    public Lotto createWinningLotto(String userInputWinningNumbers) {
        return new Lotto(parsingWinningNumbers(userInputWinningNumbers));
    }
}
