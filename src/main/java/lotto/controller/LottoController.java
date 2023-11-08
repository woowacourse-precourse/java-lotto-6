package lotto.controller;

import lotto.Lotto;
import lotto.domain.*;
import lotto.validator.Validator;
import lotto.view.*;
import main.java.lotto.domain.WinningLottos;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class LottoController {

    private static final String COMMA_SEPERATOR = ",";
    private static final int ROUND_NUMBER = 2;
    private static final int THOUSANDS = 1000;

    public void run() {
        try {
            start();
        } catch(IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
        }
    }

    public void start() {

        int money = SystemMoneyInput.readMoney();
        SystemOutput.printPurchaseAmount(money);

        int gameAmount = money / THOUSANDS;
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
        String userPickLotto = SystemLottoInput.readPickLotto();
        List<Integer> userPickNumber = getUserPickLotto(userPickLotto);
        int userBonusNumber = SystemBonusInput.readBonusNumber();
        return new UserLotto(userPickNumber, userBonusNumber);
    }

    private List<Integer> getUserPickLotto(String userPickLotto) {
        List<Integer> userPickNumber = new ArrayList<>();
        String[] userPickLottoSplit = userPickLotto.split(COMMA_SEPERATOR);
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
        double rate = (cnt * 0.1) / ((money) / THOUSANDS);
        double roundRate = roundUp(rate);
        SystemOutput.printRankResult(rankContainer, roundRate);
    }

    private double roundUp(double rate) {
        BigDecimal bd = new BigDecimal(rate);
        bd = bd.setScale(ROUND_NUMBER, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
