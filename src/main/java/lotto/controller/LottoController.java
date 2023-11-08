package lotto.controller;

import lotto.domain.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.*;

import java.util.List;

public class LottoController {

    public void start() {
        Money money = getMoney();
        printLottoCount(money);

        Lottos lottos = createLottos(money);
        printLottos(lottos);

        Lotto winningNumber = getNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
        RewardResult rewardResult = new RewardResult();
        calculateReward(rewardResult, winningNumber, bonusNumber, lottos);

        Rate rate = calculateRate(money, rewardResult);
        OutputRewardResultView.outputRewardResult(rewardResult, rate);
    }

    private Money getMoney() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        int money = inputMoneyView.inputMoney();
        return new Money(money);
    }

    private void printLottoCount(Money money) {
        OutputLottoCountView outputLottoCountView = new OutputLottoCountView();
        outputLottoCountView.outputLottoCount(money);
    }

    private Lottos createLottos(Money money) {
        int lottoCount = money.getLottoCount();
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(lottoCount));
    }

    private void printLottos(Lottos lottos) {
        OutputLottosView outputLottosView = new OutputLottosView();
        outputLottosView.outputLottos(lottos);
    }

    private Lotto getNumber() {
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        List<Integer> winningNumber = inputWinningNumberView.inputWinningNumber();
        return new Lotto(winningNumber);
    }

    private BonusNumber getBonusNumber(Lotto winningNumber) {
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();
        int bonusNumber = inputBonusNumberView.inputBonusNumber(winningNumber);
        return new BonusNumber(bonusNumber, winningNumber);
    }

    private void calculateReward(RewardResult rewardResult, Lotto winningNumber, BonusNumber bonusNumber, Lottos lottos) {
        rewardResult.calcRewardResult(winningNumber, bonusNumber, lottos);
    }

    private Rate calculateRate(Money money, RewardResult rewardResult) {
        return new Rate(money, rewardResult);
    }
}
