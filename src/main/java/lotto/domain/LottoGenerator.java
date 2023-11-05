package lotto.domain;

import static lotto.constants.Value.INITIAL_ZERO;
import static lotto.constants.Value.LOTTO_SIZE;
import static lotto.constants.Value.MAX_LOTTO_NUMBER;
import static lotto.constants.Value.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Handling;
import lotto.ui.Output;

public class LottoGenerator {
    public static List<Lotto> createLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = INITIAL_ZERO.get(); count < lottoCount; count++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.get(), MAX_LOTTO_NUMBER.get(),
                LOTTO_SIZE.get()));
    }

    public static Lotto createWinningLotto(String userInput) {
        boolean isRunning = true;
        Lotto winningLotto = null;

        while (isRunning) {
            try {
                winningLotto = new Lotto(Handling.parseNumbers(Handling.split(userInput)));
                isRunning = false;
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return winningLotto;
    }

    public static Integer createBonusNumber(Lotto winningLotto, String userInput) {
        boolean isRunning = true;

        while (isRunning) {
            try {
                Lotto.checkLottoNumber(userInput);
                winningLotto.checkInclusion(Integer.parseInt(userInput));
                isRunning = false;
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return Integer.parseInt(userInput);
    }
}
