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
}
