package lotto.controller;

import lotto.controller.action.LottoAction;
import lotto.controller.action.WinningAction;
import lotto.domain.constant.Rank;
import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.controller.constant.ErrorConst.INPUT_NOT_INT;
import static lotto.controller.constant.ErrorConst.INPUT_NOT_LONG;
import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_BONUS_REQUEST;
import static lotto.ui.constant.MessageConst.WINNING_DETAILS_NOTICE;
import static lotto.ui.constant.MessageConst.WINNING_MAIN_REQUEST;

public class LottoController {

    private final LottoService service = new LottoService();

    private final LottoAction lottoAction = new LottoAction();
    private final WinningAction winningAction = new WinningAction();

    public void purchaseLotteries() {
        lottoAction.process(PURCHASE_REQUEST, service);
    }

    public void provideLotteriesDetails() {
        List<Lotto> lottoStorage = service.getLottoStorage();
        OutputView.printAmountNotice(lottoStorage.size());

        for (Lotto lotto : lottoStorage) {
            OutputView.printLotto(lotto.getNumbers());
        }
    }

    public void setUpWinning() {
        winningAction.processWinningMain(WINNING_MAIN_REQUEST);
        winningAction.processWinningComplete(WINNING_BONUS_REQUEST, service);
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
