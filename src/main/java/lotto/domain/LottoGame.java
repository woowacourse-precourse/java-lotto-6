package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.input.Input;
import lotto.output.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final List<Lotto> lottos = new ArrayList<>();
    int lottoCount;

    public void play() {
        startGame();
//        playGame();
//        endGame();
    }

    private void startGame() {
        lottoCount = Input.getPurchaseAmount() / 1000;
        Output.printLottoAmount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(makeRandomNumbers()));
        }
        for (Lotto lotto : lottos) {
            Output.printLotto(lotto);
        }
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
