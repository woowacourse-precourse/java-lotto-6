package lotto.controller;

import lotto.controller.handler.DrawHandler;
import lotto.controller.machine.Judgment;
import lotto.controller.machine.NumberGenerator;
import lotto.controller.user.LottoPurchase;
import lotto.domain.Lotto;
import lotto.model.LottoReceipt;
import lotto.model.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    private LottoReceipt lottoReceipt;
    private LottoTicket lottoTicket;

    public LottoMachine() {
        lottoTicket = new LottoTicket();
        lottoReceipt = new LottoReceipt();
    }

    private List<Lotto> createLottos(int count) {
        NumberGenerator numberGenerator = new NumberGenerator();

        return numberGenerator.createLottos(count);
    }

    private void purchase(InputView inputView, OutputView outputView) {
        LottoPurchase lottoPurchase = new LottoPurchase(lottoReceipt, inputView);
        lottoPurchase.purchase();

        List<Lotto> lottos = createLottos(lottoReceipt.getPurchaseCount());
        lottoTicket.setLottos(lottos);

        outputView.showLottoCount(lottoReceipt.getPurchaseCount());
        outputView.showLottos(lottoTicket.getLottos());
    }

    private void judge(OutputView outputView) {
        Judgment judgment = new Judgment();

        judgment.judge(lottoTicket);
        judgment.showResult(outputView);
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DrawHandler drawHandler = new DrawHandler(inputView);

        purchase(inputView, outputView);
        drawHandler.drarw(lottoTicket);
        judge(outputView);
    }
}
