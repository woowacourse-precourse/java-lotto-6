package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int money = inputView.getPurchasePrice();
        int quantity = calculateQuantity(money);
        outputView.printLottoQuantity(quantity);
        List<Lotto> lottos = pickLottoNumbers(quantity);
        outputView.printLottoNumbers(lottos);
        WinningLotto winningLotto = inputView.getWinningNumbers();

    }

    private List<Lotto> pickLottoNumbers(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private int calculateQuantity(int money) {
        return money / 1000;
    }

}

