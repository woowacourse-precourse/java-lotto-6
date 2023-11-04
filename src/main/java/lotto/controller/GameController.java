package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ConfigurationNumbers;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Pay;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    Pay pay;
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
        List<Lotto> lottos = generateUserLottos();
        userLottos = new LottoList(lottos);
        printUserLottos((userLottos.getLottos()));
    }

    // TODO: 클래스 분리해보기!
    public void startGame() {
        
    }

    private List<Lotto> generateUserLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < pay.getLottoAmounts(); i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                ConfigurationNumbers.MIN_NUMBER.getNumber(),
                ConfigurationNumbers.MAX_NUMBER.getNumber(),
                ConfigurationNumbers.LOTTO_LENGTH.getNumber()
        );
    }

    private void printUserLottos(List<Lotto> lottoList) {
        outputView.printAmmountLotto(lottoList.size());
        for (Lotto lotto : lottoList) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }
}
