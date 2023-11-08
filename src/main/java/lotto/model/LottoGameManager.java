package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.rule.LottoGameRule;
import lotto.rule.UserRule;
import lotto.util.validator.InputValidator;
import lotto.util.validator.LottoCostValidator;
import lotto.util.validator.LottoNumbersValidator;

public class LottoGameManager {
    private int bonusNumber;
    private Lotto winningLotto;
    private LottoBucket lottoBucket;

    public LottoGameManager() {
    }

    //LottoBucket 만드는 메서드
    public void createLottoBucket(String userInputLottoCost) {
        lottoBucket = new LottoBucket(calculateLottoAmount(userInputLottoCost));
    }

    private int calculateLottoAmount(String userInputLottoCost) {
        int lottoCost = Integer.parseInt(userInputLottoCost);
        LottoCostValidator.validateLottoCostUnit(lottoCost);
        return lottoCost / LottoGameRule.LOTTO_COST_UNIT.getConstant();
    }

    public List<String> getPublishedLotto() {
        return lottoBucket.getPublishedLotto();
    }

    //보너스 번호 없는 당첨 로또만 만드는 메서드
    public void createWinningLotto(String userInputWinningNumbers) {
        winningLotto = LottoCreator.createWinningLotto(parsingWinningNumbers(userInputWinningNumbers));
    }

    private List<Integer> parsingWinningNumbers(String userInputWinningNumbers) {
        List<Integer> parsedWinningNumbers = new ArrayList<>();
        for (String lottoNumber : splitWinningNumbers(userInputWinningNumbers)) {
            InputValidator.validateNumeric(lottoNumber);
            int parsedNumber = Integer.parseInt(lottoNumber.trim());
            LottoNumbersValidator.validateLottoNumberRange(parsedNumber);
            parsedWinningNumbers.add(parsedNumber);
        }
        return parsedWinningNumbers;
    }

    private List<String> splitWinningNumbers(String userInputWinningNumbers) {
        return List.of(userInputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.getValue()));
    }

    //입력받은 보너스 번호 검증하고 파싱하는 메서드
    public void parsingBonusNumber(String userInputBonusNumber) {
        int bonusNumber = Integer.parseInt(userInputBonusNumber);
        LottoNumbersValidator.validateLottoNumberRange(bonusNumber);
        LottoNumbersValidator.validateContainLottoNumbers(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    //RankingManager에 발행된 로또, 당첨 로또, 보너스 번호 주는 메서드
    public RankingManager generateRankingManager() {
        return new RankingManager(lottoBucket, winningLotto, bonusNumber);
    }
}
