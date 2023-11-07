package lotto.controller;

import lotto.Lotto;
import lotto.domain.*;
import lotto.validator.Validator;
import lotto.view.SystemOutput;
import main.java.lotto.domain.WinningLottos;
import lotto.view.SystemInput;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        try {
            start();
        } catch(IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
        }
    }

    public void start() {

        int money = SystemInput.readMoney();
        SystemOutput.printPurchaseAmount(money);

        int gameAmount = money / 1000;
        WinningLottos winningLottos = createWinningLottos(gameAmount);
        SystemOutput.printWiningLotto(winningLottos);

        UserLotto userLotto = getUserLotto();

        RankContainer rankContainer = new RankContainer();
        Calculator calculator = new Calculator();
        calculator.match(rankContainer, userLotto, winningLottos);
        long cnt = getSum(rankContainer, calculator);
        getRate(rankContainer, cnt, money);
    }

    private WinningLottos createWinningLottos(int gameAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> winlottos = lottoGenerator.lottoGenerateWinningLotto(gameAmount);
        return new  WinningLottos(winlottos);
    }

    private UserLotto getUserLotto() {
        String userPickLotto = SystemInput.readPickLotto();
        List<Integer> userPickNumber = getUserPickLotto(userPickLotto);
        int userBonusNumber = SystemInput.readBonusNumber();
        return new UserLotto(userPickNumber, userBonusNumber);
    }

    private List<Integer> getUserPickLotto(String userPickLotto) {
        List<Integer> userPickNumber = new ArrayList<>();
        String[] userPickLottoSplit = userPickLotto.split(",");
        for (String userpick : userPickLottoSplit) {
            userPickNumber.add(Integer.parseInt(userpick));
        }
        return userPickNumber;
    }

    private long getSum(RankContainer rankContainer, Calculator calculator) {
        int cnt = 0;
        for (Rank rank : Rank.values()) {
            cnt += rankContainer.getRankContainer(rank) * rank.getAward();
        }
        return cnt;
    }

    private void getRate(RankContainer rankContainer, long cnt, int money) {
        double rate = (cnt * 0.1) / ((money) / 1000);
        SystemOutput.printRankResult(rankContainer, rate);
    }
}
