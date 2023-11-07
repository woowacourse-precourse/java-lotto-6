package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.WinningStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.View.InputView.*;
import static lotto.View.OutputView.printLottos;
import static lotto.View.OutputView.printWinningStatistics;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        printLottos(lottos);
        printWinningStatistics(lottos, winningNumbers, bonusNumber);
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}
