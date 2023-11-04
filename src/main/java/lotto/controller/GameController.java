package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Pay;
import lotto.domain.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    Pay pay;
    Lotto winningNumbers;
    LottoList userLottos;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public void run() {
        initGame();
        startGame();
    }

    public void initGame() {
        outputView.printPaymentRequest();
        pay = new Pay(inputView.enterCost());
    }

    //todo: 메서드 분리해보기!!!
    public void startGame() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < pay.getLottoAmounts(); i++) {
            RandomGenerator randomGenerator = new RandomGenerator();
            Lotto lotto = new Lotto(randomGenerator.getRandomNumbers());
            lottoList.add(lotto);
        }
        userLottos = new LottoList(lottoList);
        outputView.printLottoNumbers(lottoList);
    }
}
