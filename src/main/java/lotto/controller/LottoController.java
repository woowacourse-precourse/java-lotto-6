package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void play() {
        outputView.printPurchaseAmount();
        int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = LOTTO_TICKET_PRICE; i <= purchaseAmount; i += LOTTO_TICKET_PRICE) {
            Lotto lotto = lottoService.createLotto(createNumbers());
            lottos.add(lotto);
        }
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
    }
}
