package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.LongStream;
import lotto.controller.Rank;

public class Lottos {
    private static final int ZERO = 0;
    private final List<Lotto> havingNumbers;

    public Lottos() {
        this.havingNumbers = new ArrayList<>();
    }

    private void printLotto() {
        havingNumbers.forEach(Lotto::printLotto);
    }

    public void purchaseLotto(long number) {
        LongStream.range(ZERO, number)
                .forEach(i -> havingNumbers.add(new Lotto()));

        printLotto();
    }

    public HashMap<Rank, Long> checkWin(Lotto answerNumber, int bonusNumber) {
        HashMap<Rank, Long> winResult = new HashMap<>();

        for (Lotto lotto : havingNumbers) {
            Rank rank = Rank.value(lotto.checkNumber(answerNumber), lotto.checkBonus(bonusNumber));
            winResult.put(rank, winResult.getOrDefault(rank, (long) ZERO) + 1);
        }

        return winResult;
    }
}