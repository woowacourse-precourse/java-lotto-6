package lotto.controller;


import lotto.domain.Payment;
import lotto.service.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Payment payment = inputView.inputPayment();
        LottoBuyer lottoBuyer = new LottoBuyer(payment);
        lottoBuyer.generateLotto();
        outputView.printLottoNumbers(lottoBuyer.getLottos());
    }


}
