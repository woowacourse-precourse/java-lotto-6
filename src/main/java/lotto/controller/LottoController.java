package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.controller.handler.LottoHandler;
import lotto.controller.handler.WinningHandler;
import lotto.domain.constant.Rank;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.output.OutputView;

import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_BONUS_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_DETAILS_NOTICE;
import static lotto.ui.constant.MessageConst.WINNING_MAIN_REQUEST;

public class LottoController {

    private final LottoService service = new LottoService();

    private final LottoHandler lottoHandler = new LottoHandler();
    private final WinningHandler winningHandler = new WinningHandler();

    public void purchaseLotteries() {
        lottoHandler.process(PURCHASE_REQUEST, service);
    }

    public void provideLotteriesDetails() {
        List<Lotto> lottoStorage = service.getLottoStorage();
        OutputView.printAmountNotice(lottoStorage.size());

        for (Lotto lotto : lottoStorage) {
            OutputView.printLotto(lotto.getNumbers());
        }
    }

    public void setUpWinning() {
        winningHandler.processWinningOngoing(WINNING_MAIN_REQUEST);
        winningHandler.processWinningComplete(WINNING_BONUS_REQUEST, service);
    }

    public void provideWinningDetails() {
        OutputView.printMessage(WINNING_DETAILS_NOTICE);

        service.rank();

        Map<Rank, Integer> winningDetails = service.getWinningDetails();
        for (Map.Entry<Rank, Integer> entry : winningDetails.entrySet()) {
            String description = entry.getKey().getDescription();
            Integer count = entry.getValue();

            OutputView.printWinningDetail(description, count);
        }
    }

    public void provideRateOfReturn() {
        double rateOfReturn = service.calculateReturn();

        OutputView.printRateOfReturn(rateOfReturn);
    }
}
