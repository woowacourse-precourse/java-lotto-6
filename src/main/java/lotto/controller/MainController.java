package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.PrizeStorage;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.utils.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        /* 로또 구매 금액을 입력받고, 구입한 로또를 출력한다. */
        final int amount = inputView.inputBuyAmount();
        final UserLotto userLotto = new UserLotto(buyLotto(amount / Constants.LOTTO_PRICE));
        outputView.printUserLotto(userLotto.getUserLotto());

        /* 당첨 번호와 보너스 번호를 입력받고, 당첨 목록을 저장한다. */
        final WinningLotto winningLotto = new WinningLotto(inputView.inputWinningLotto(), inputView.inputBonusNumber());
        final List<Prize> prizes = winningLotto.calculateTotalPrize(userLotto.getUserLotto());
        final PrizeStorage prizeStorage = new PrizeStorage(prizes);
        final List<Integer> prizeCount = prizeStorage.getPrizeCount();

        /* 당첨 통계를 출력한다. */
        final double profitRate = calculateProfitRate(prizes, amount);
        outputView.printWinningStatistics(prizeCount, profitRate);
    }

    private List<Lotto> buyLotto(int count) {
        final List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(getNewLotto());
        }
        return lotto;
    }

    private Lotto getNewLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.MIN_RANGE, Constants.MAX_RANGE, Constants.LOTTO_SIZE));
    }

    private double calculateProfitRate(List<Prize> prizes, int amount) {
        double totalPrizesMoney = prizes.stream()
                .mapToDouble(Prize::getPrizeMoney)
                .sum();
        return (totalPrizesMoney / amount) * 100;
    }
}
