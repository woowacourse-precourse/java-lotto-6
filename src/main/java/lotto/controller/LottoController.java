package lotto.controller;

import lotto.model.*;
import lotto.view.Views;
import lotto.service.LottoService;
import java.util.EnumMap;

public class LottoController {
    public void run() {
        LottoPrice lottoPrice = Views.inputPrice();
        Lottos lottos = LottoService.createLottos(lottoPrice.getPrice());
        Views.printLottoCount(lottos.getBuyAmount());
        Views.printLottos(lottos);
        Lotto winningNumber = Views.inputWinningNumber();
        BonusNumber bonusNumber = Views.inputBonusNumber();
        EnumMap<Ranking, Integer> result = LottoService.getResult(lottos, winningNumber.getNumbers(), bonusNumber.getBonusNum());
        Views.printResult(result);
        Views.printIncome(LottoService.calculateIncome(lottoPrice.getPrice(), result));
    }
}
