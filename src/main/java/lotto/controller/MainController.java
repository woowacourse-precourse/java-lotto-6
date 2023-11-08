package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.PrizeStorage;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.util.Constants;
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
        final int amount = inputView.inputBuyAmount();
        final UserLotto userLotto = new UserLotto(buyLotto(amount));
        outputView.printUserLotto(userLotto.getMyLotto());

        final WinningLotto winningLotto = new WinningLotto(
                inputView.inputWinningLotto(), inputView.inputBonusNumber());
        final List<Prize> prizes = winningLotto.calculateTotalPrize(userLotto.getMyLotto());
        PrizeStorage prizeStorage = new PrizeStorage(prizes);
        List<Integer> prizeCount = prizeStorage.getPrizeCount();

        double TotalReturn = (getTotalReturn(prizes) / amount) * 100;
        outputView.printWinningStatistics(prizeCount, TotalReturn);
    }

    public List<Lotto> buyLotto(int amount) {
        int lottoCount = amount / Constants.LOTTO_PRICE;
        final List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(getNewLotto());
        }
        return lotto;
    }

    public Lotto getNewLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constants.MIN_RANGE, Constants.MAX_RANGE, Constants.LOTTO_SIZE));
    }

    public double getTotalReturn(List<Prize> prizes) {
        return prizes.stream()
                .mapToDouble(Prize::getPrizeMoney)
                .sum();
    }
}
