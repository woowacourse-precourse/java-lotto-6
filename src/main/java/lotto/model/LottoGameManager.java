package lotto.model;

import lotto.model.validator.LottoCostValidator;

public class LottoGameManager {
    private final LottoPublisher lottoPublisher;

    public LottoGameManager(LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
    }

    public void validateLottoCost(String userInputLottoCost) {
        LottoCostValidator.validateBlank(userInputLottoCost);
        LottoCostValidator.validateNumeric(userInputLottoCost);
        LottoCostValidator.validateThousandUnit(userInputLottoCost);
    }

    public Integer parsingLottoCost(String userInputLottoCost) {
        return Integer.parseInt(userInputLottoCost);
    }
}
