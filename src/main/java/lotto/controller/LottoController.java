package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private LottoService lottoService;
    private Integer totalMoney;
    private Integer lottoCount;

    /* Constant */
    private static final Integer LOTTO_PRICE = 1000;
    private static final String MSG_CHANGE_ERROR = "잔돈이 남으면 예외가 발생합니다.";


    public LottoController() {
        lottoService = new LottoService();
    }
    public void run() {
        InputView.printPurchaseAmountRequest();
        initializeTotalMoney();

        initializeAmountLotto();
        lottoService.addRandomLotto(lottoCount);

        InputView.printWinningNumberRequest();
        lottoService.addWiningNumbers();

        InputView.printBonusNumberRequest();
        lottoService.getBonusNumber();

        // 당첨 통계 계산
        lottoService.calculateLottoWinningNumbers();

        // 당첨 통계 출력
    }

    private void initializeTotalMoney() {
        totalMoney = Integer.parseInt(InputView.getUserInput());
    }

    private void initializeAmountLotto() {
        final int restMoney = totalMoney % LOTTO_PRICE;
        if (restMoney != 0) {
            throw new IllegalArgumentException(MSG_CHANGE_ERROR);
        }
        lottoCount = totalMoney / LOTTO_PRICE;
    }
}
