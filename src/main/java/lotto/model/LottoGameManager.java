package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.common.config.LottoGameRule;
import lotto.common.config.UserRule;
import lotto.model.validator.LottoCostValidator;
import lotto.model.validator.LottoNumbersValidator;

public class LottoGameManager {

    public LottoGameManager() {
    }

    private void validateCommon(String userInput) {
        LottoCostValidator.validateBlank(userInput);
        LottoCostValidator.validateNumeric(userInput);
    }

    //LottoBucket 만드는 메서드
    public LottoBucket createLottoBucket(String userInputLottoCost) {
        return new LottoBucket(calculateLottoAmount(userInputLottoCost));
    }

    private int calculateLottoAmount(String userInputLottoCost) {
        validateCommon(userInputLottoCost);

        int lottoCost = Integer.parseInt(userInputLottoCost);
        LottoCostValidator.validateLottoCostUnit(lottoCost);
        return lottoCost / LottoGameRule.LOTTO_COST_UNIT.constant();
    }

    //보너스 번호 없는 당첨 로또만 만드는 메서드
    public Lotto createWinningLotto(String userInputWinningNumbers) {
        return LottoCreator.createManualLotto(parsingWinningNumbers(userInputWinningNumbers));
    }

    private List<Integer> parsingWinningNumbers(String userInputWinningNumbers) {
        List<Integer> parsedWinningNumbers = new ArrayList<>();
        for (String lottoNumber : splitWinningNumbers(userInputWinningNumbers)) {
            validateCommon(lottoNumber);

            int parsedNumber = Integer.parseInt(lottoNumber.trim());
            LottoNumbersValidator.validateLottoNumberRange(parsedNumber);
            parsedWinningNumbers.add(parsedNumber);
        }
        return parsedWinningNumbers;
    }

    private List<String> splitWinningNumbers(String userInputWinningNumbers) {
        return List.of(userInputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.value()));
    }

    //보너스 번호와 당첨 로또를 주는 메서드
    public LottoRanking createWinningLottoAddBonusNumber(Lotto lotto, String userInputBonusNumber) {
        return new LottoRanking(lotto, userInputBonusNumber);
    }
}
