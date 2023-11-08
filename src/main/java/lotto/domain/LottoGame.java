package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Input;
import lotto.output.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final List<Lotto> lottos = new ArrayList<>();
    public static List<Integer> winningNumbers;
    private int lottoCount;

    public void play() {
        startGame();
        playGame();
//        endGame();
    }

    private void startGame() {
        lottoCount = Input.getPurchaseAmount() / 1000;
        System.out.println();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(makeRandomNumbers()));
        }
        Output.printLottoAmount(lottoCount);
        for (Lotto lotto : lottos) {
            Output.printLotto(lotto);
        }
        System.out.println();
    }

    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private void playGame() {
        winningNumbers = Input.getWinningNumbers();
    }
}
