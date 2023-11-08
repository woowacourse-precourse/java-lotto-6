package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.Input;
import lotto.output.Output;

import java.util.*;

public class LottoGame {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static int[] ranks = {0, 0, 0, 0, 0};
    private static int lottoCount;
    private static int profit = 0;

    public void play() {
        startGame();
        playGame();
        endGame();
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
        List<Integer> winningNumbers = Input.getWinningNumbers();
        int bonusNumber = Input.getBonusNumber();

        for (Lotto lotto : lottos) {
            int rank = getRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            if (rank > 0) {
                ranks[rank - 1] += 1;
                profit += 1;
            }
        }
    }

    private int getRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
        lottoNumberSet.retainAll(winningNumberSet);

        int rightNumber = lottoNumberSet.size();
        if (rightNumber == 6) {
            return 1;
        } else if (rightNumber == 5 && lottoNumbers.contains(bonusNumber)) {
            return 2;
        } else if (rightNumber == 5) {
            return 3;
        } else if (rightNumber == 4) {
            return 4;
        } else if (rightNumber == 3) {
            return 5;
        }
        return 0;
    }

    private void endGame() {
        Output.printLottoResult(ranks);
        Output.printProfit(profit, lottoCount);
    }
}
