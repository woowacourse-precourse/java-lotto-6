package lotto.controller;

import lotto.domain.DrawResult;
import lotto.service.LottoService;
import lotto.service.LottosDTO;
import lotto.service.PriceDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        LottoService lottoService = createLottoService();
        LottosDTO lottosDTO = lottoService.purchase();
        PriceDTO priceDTO = lottoService.getPriceDTO();
        OutputView.printLottos(lottosDTO, priceDTO);

        setWinningLotto(lottoService);
        setBonusNumber(lottoService);
        DrawResult drawResult = lottoService.draw();
        OutputView.printResult(drawResult, priceDTO);
    }

    private static void setBonusNumber(LottoService lottoService) {
        try {
            lottoService.setBonusNumber(InputView.takeBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber(lottoService);
        }
    }

    private static void setWinningLotto(LottoService lottoService) {
        try {
            lottoService.setWinningLotto(InputView.takeWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinningLotto(lottoService);
        }
    }

    private static LottoService createLottoService() {
        try {
            LottoService lottoService = new LottoService(InputView.takeInputPrice());
            return lottoService;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return createLottoService();
        }
    }
}

