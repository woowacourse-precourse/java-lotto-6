package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoService lottoService = new LottoService();
    private Buyer buyer;
    private WinningLotto winningLotto;
    public void run() {
        buyLotto();
        initWinningLotto();
//        matchLottos();
//        showResult();
    }

    private void initWinningLotto() {
        List<Integer> inputNumbers = LottoUtils.stringToList(readLine().trim());
        winningLotto = new WinningLotto(inputNumbers, readLine().trim());
    }

    private void buyLotto() {
        InputView.inputPrise();
        buyer = new Buyer(readLine().trim());
        buyer.showLottos();
    }
}
