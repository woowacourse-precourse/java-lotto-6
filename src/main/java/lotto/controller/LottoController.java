package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static InputView inputView = new InputView();
    public static LottoService lottoService = new LottoService();
    public static List<Lotto> lottos = new ArrayList<>();

    public void start() {
        int amount = inputView.inputAmount();
        lottos = lottoService.makeLottoList(amount);
    }
}
