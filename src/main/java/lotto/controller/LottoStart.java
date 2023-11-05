package lotto.controller;

import lotto.domain.*;
import lotto.generator.LottoGenerator;
import lotto.view.InputBonusNumView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputLottoNumView;
import lotto.view.OutputView;

public class LottoStart {
    public void start() {
        Money money = getLottoMoney();
        OutputView.printBuyLotto(money);

        Lottos lottos = getLottos(money);
        OutputView.printLottos(lottos);

        UserLottoNum userLottoNum = getUserLotto();
        RankResult rankResult = new RankResult();
        rankResult.calcRankResult(userLottoNum, lottos);
        OutputView.printRankReuslt(rankResult);

        BenefitRate benefitRate = getRate(money, rankResult);
        OutputView.printBenefitRate(benefitRate);
    }

    private Money getLottoMoney() {
        while(true){
            try {
                InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
                int money = inputBuyLottoView.getValue();
                return new Money(money);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoSet(money.getTicket()));
    }

    private Lotto getInputLotto() {
        while(true) {
            try {
                InputLottoNumView inputLottoNumView = new InputLottoNumView();
                return new Lotto(inputLottoNumView.getValue());
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private UserLottoNum getUserLotto() {
        Lotto lotto = getInputLotto();
        while(true) {
            try {
                InputBonusNumView inputBonusNumView = new InputBonusNumView();
                return new UserLottoNum(lotto, inputBonusNumView.getValue());
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

    }

    private BenefitRate getRate(Money money, RankResult rankResult) {
        return new BenefitRate(money, rankResult);
    }
}
