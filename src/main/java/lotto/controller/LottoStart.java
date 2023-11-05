package lotto.controller;

import lotto.domain.*;
import lotto.generator.LottoGenerator;
import lotto.view.InputBonusNumView;
import lotto.view.InputBuyLottoView;
import lotto.view.InputLottoNumView;
import lotto.view.OutputView;

import java.util.List;

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
        InputBuyLottoView inputBuyLottoView = new InputBuyLottoView();
        int money = inputBuyLottoView.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoSet(money.getTicket()));
    }

    private UserLottoNum getUserLotto() {
        InputLottoNumView inputLottoNumView = new InputLottoNumView();
        InputBonusNumView inputBonusNumView = new InputBonusNumView();

        List<Integer> inputLottoNum = inputLottoNumView.getValue();
        Integer bonusNum = inputBonusNumView.getValue();

        return new UserLottoNum(inputLottoNum, bonusNum);
    }

    private BenefitRate getRate(Money money, RankResult rankResult) {
        return new BenefitRate(money, rankResult);
    }
}
