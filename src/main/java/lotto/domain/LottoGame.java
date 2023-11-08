package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    List<Integer> winningNumbers = new ArrayList<>();
    int lottoCount;
    public void play() {
        startGame();
//        playGame();
//        endGame();
    }

    private void startGame() {
        lottoCount = Input.getPurchaseAmount() / 1000;
        System.out.println(lottoCount);
//        makeRandomNumbers();
    }

    private void makeRandomNumbers() {
        winningNumbers.clear();
        while (winningNumbers.size() < 6) {
            int randomNum = Randoms.pickNumberInRange(1, 45);
            if (!winningNumbers.contains(randomNum)) {
                winningNumbers.add(randomNum);
            }
        }
    }
}
