package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.ResultCode;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lotto() {
        Game game = new Game();

        // TODO: 로또 구입 금액 입력
        Integer purchasePrice = 0;
         while (true) {
            try {
                purchasePrice = lottoService.readPurchasePrice();
                game.setLottos(lottoService.issueLotto(purchasePrice));
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // TODO: 발행한 로또 수량 및 번호 출력
        lottoService.printLottoCount(game.getLottos().size());
        for (Lotto lotto : game.getLottos()) {
            lottoService.printLotto(lotto);
        }
        System.out.println();

        // TODO: 당첨 번호 입력
        while (true) {
            try {
                game.setWinningNumbers(lottoService.readWinningNumbers());
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // TODO: 보너스 번호 입력
        while (true) {
            try {
                game.setBonusNumber(lottoService.readBonusNumber());
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // TODO: 당첨 내역, 수익률 출력
        Map<ResultCode, Integer> temp = game.calculate();
        lottoService.printResult(temp);
        lottoService.printProfitability(game.calculateProfitability(temp, purchasePrice));
    }
}
