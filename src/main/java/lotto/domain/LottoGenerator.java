package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Handling;
import lotto.ui.Input;
import lotto.ui.Output;

public class LottoGenerator {
    // 로또 생성 컴퓨터
    public static List<Lotto> createLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static Lotto generateLotto() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

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

}
