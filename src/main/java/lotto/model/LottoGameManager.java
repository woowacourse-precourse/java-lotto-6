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

    public int calculateLottoAmount(String userInputLottoCost) {
        validateCommon(userInputLottoCost);

        int lottoCost = Integer.parseInt(userInputLottoCost);
        LottoCostValidator.validateLottoCostUnit(lottoCost);
        return lottoCost / LottoGameRule.LOTTO_COST_UNIT.constant();
    }

    private List<String> splitWinningNumbers(String userInputWinningNumbers) {
        return List.of(userInputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.value()));
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

    public Lotto createWinningLotto(String userInputWinningNumbers) {
        return LottoMaker.makeManualLotto(parsingWinningNumbers(userInputWinningNumbers));
    }

    public LottoRanking createWinningLottoAddBonusNumber(Lotto lotto, String userInputBonusNumber) {
        return new LottoRanking(lotto, userInputBonusNumber);
    }

    public List<Lotto> createLottoBucket(int lottoAmount) {
        return null;
    }
    public void saveLottoBucket() {

    }
}
