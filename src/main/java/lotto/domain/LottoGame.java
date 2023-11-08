package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Input;
import lotto.output.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    private int lottoCount;

    public void play() {
        startGame();
        playGame();
//        endGame();
    }

    private void startGame() {
        lottoCount = Input.getPurchaseAmount() / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(makeRandomNumbers()));
        }

        Output.printLottoAmount(lottoCount);
        for (Lotto lotto : lottos) {
            Output.printLotto(lotto);
        }
    }

    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private void playGame() {
        winningNumbers = Input.getWinningNumbers();
        bonusNumber = Input.getBonusNumber();
    }
}
