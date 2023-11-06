package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.common.config.LottoGameRule;
import lotto.common.config.UserRule;
import lotto.model.validator.LottoCostValidator;
import lotto.model.validator.LottoNumbersValidator;

public class LottoGameManager {
    private int bonusNumber;
    private Lotto winningLotto;
    private LottoBucket lottoBucket;

    public LottoGameManager() {
    }

    private void validateCommon(String userInput) {
        LottoCostValidator.validateBlank(userInput);
        LottoCostValidator.validateNumeric(userInput);
    }

    //LottoBucket 만드는 메서드
    public void createLottoBucket(String userInputLottoCost) {
        lottoBucket = new LottoBucket(calculateLottoAmount(userInputLottoCost));
    }

    private int calculateLottoAmount(String userInputLottoCost) {
        validateCommon(userInputLottoCost);
        int lottoCost = Integer.parseInt(userInputLottoCost);
        LottoCostValidator.validateLottoCostUnit(lottoCost);
        return lottoCost / LottoGameRule.LOTTO_COST_UNIT.getConstant();
    }

    public String showPublishedLotto() {
        return lottoBucket.showLottoBucket();
    }

    //보너스 번호 없는 당첨 로또만 만드는 메서드
    public void createWinningLotto(String userInputWinningNumbers) {
        winningLotto = LottoCreator.createWinningLotto(parsingWinningNumbers(userInputWinningNumbers));
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

    //입력받은 보너스 번호 검증하고 파싱하는 메서드
    public void parsingBonusNumber(String userInputBonusNumber) {
        LottoNumbersValidator.validateBlank(userInputBonusNumber);
        LottoNumbersValidator.validateNumeric(userInputBonusNumber);
        int bonusNumber = Integer.parseInt(userInputBonusNumber);
        LottoNumbersValidator.validateLottoNumberRange(bonusNumber);
        LottoNumbersValidator.validateContainLottoNumbers(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    //LottoRanking에 LottoBucket, 당첨로또, 보너스 번호 주는 메서드
    public LottoRanking createWinningLottoAddBonusNumber() {
        return new LottoRanking(lottoBucket, winningLotto, bonusNumber);
    }
}
