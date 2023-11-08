package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.view.OutputView;

import java.util.HashMap;

public class LottoCalculateService {
    private OutputView outputView = new OutputView();
    private HashMap<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        outputView.responseYieldOfLotto(getYieldOfLotto(user, user.getWinningPrice()));
    }

}
