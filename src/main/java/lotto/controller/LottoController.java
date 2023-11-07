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
    // 금액을 입력받는다
    // 금액을 통해 게임 개수를 구한다
    // 게임 수를 출력한다
    // 게임 수에 맞게 로또가 발행된다
    // 발행된 로또를 출력한다
    // 유저가 로또 번호를 입력하고 보너스 번호를 입력한다
    // 발행된 로또와 유저가 입력한 로또에서 같은 번호를 찾는다
    // rank를 출력한다
    // rate을 출력한다
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
