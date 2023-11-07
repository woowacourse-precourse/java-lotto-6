package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.element.*;
import lotto.view.*;

import java.util.*;

public class Controller {

    Input input;
    Output output;
    Lotto winning;
    Bonus bonus;
    List<Lotto> lottoes;
    int amount;

    void start() {
        getLottoNumbers();
        getWinningNumbers();

        int[] winCount = new int[5];
        for (Lotto lotto : lottoes) {
            winCount[getIndex(lotto)]++;
        }
        output.printWinnings(winCount);
        output.printRevenue(getRevenue(winCount));
    }

    void getLottoNumbers() {
        amount = input.inputAmount();
        for (int cnt = 0; cnt < amount/1000; cnt++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoes.add(new Lotto(numbers));
        }
        output.printLottoes(lottoes);
    }

    void getWinningNumbers() {
        winning = new Lotto(input.inputNumbers());
        bonus = new Bonus(input.inputBonus(), winning);
    }

    int getIndex(Lotto lotto) {
        int matchCount = winning.countMatch(lotto);
        boolean bonusMatch = bonus.isBonusMatch(lotto);

        if (matchCount == 3) return 0;
        if (matchCount == 4) return 1;
        if (matchCount == 5 && !bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 6) return 4;
        return -1;
    }

    double getRevenue(int[] winCount) {
        int sum = 0;
        for (WinningDetails wd : WinningDetails.values()) {
            sum += winCount[wd.ordinal()] * wd.getPrize();
        }
        return (double) sum / amount * 100;
    }
}
