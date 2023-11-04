package lotto.controller;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputUtil;
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
        InputView.inputNumbers();
        List<Integer> inputNumbers = LottoUtils.stringToList(InputUtil.inputStringWithTrim());
        InputView.inputBonusNumber();
        winningLotto = new WinningLotto(inputNumbers, InputUtil.inputStringWithTrim());
    }

    private void buyLotto() {
        InputView.inputPrise();
        buyer = new Buyer(InputUtil.inputStringWithTrim());
        buyer.showLottos();
    }
}
