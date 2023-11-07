package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoService lottoService = new LottoService(new User(), new WinningNumber(), new LottoResult());
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoService, lottoView);
        lottoController.inputMoney();
        lottoController.getLottoTicketsInfo();
        lottoController.setLottoWinningNumbers();
        lottoController.getNumbersMatchesResult();
        lottoController.printRevenue();
    }
}
