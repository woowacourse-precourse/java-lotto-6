package lotto;

import lotto.controller.LottoController;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {

    private final InputView lottoMoneyInputView;
    private final LottoController lottoController;

    public Application(InputView lottoMoneyInputView, LottoController lottoController) {
        this.lottoMoneyInputView = lottoMoneyInputView;
        this.lottoController = lottoController;
    }

    public static void main(String[] args) {
        Application app = init();
        app.run();
    }

    public static Application init() {
        AppConfig appConfig = new AppConfig();
        return new Application(
                appConfig.lottoMoneyInputView(),
                appConfig.lottoController(appConfig.lottoService())
        );
    }

    private void run() {
        String money = lottoMoneyInputView.read();
        OutputView lottoTicketInfoView = lottoController.createLottoTicket(money);
        lottoTicketInfoView.render();
    }
}
