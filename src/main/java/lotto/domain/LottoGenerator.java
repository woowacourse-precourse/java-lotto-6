package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Validator;
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

    public static Integer createBonusNumber(Lotto winningLotto) {
        boolean isRunning = true;
        Integer bonusNumber = null;

        while (isRunning) {
            try {

                String userInput = Computer.getInput();

                Validator.checkNumber(userInput);
                Validator.checkZero(userInput);

                bonusNumber = Integer.parseInt(userInput);
                Validator.checkRange(bonusNumber);
                winningLotto.checkInclusion(bonusNumber);

                isRunning = false;

            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return bonusNumber;
    }

    public static Lotto createWinningLotto() {
        boolean isRunning = true;
        Lotto winningLotto = null;

        while (isRunning) {
            try {
                winningLotto = new Lotto(Computer.parseInput(Computer.splitInput(Computer.getInput())));
                isRunning = false;
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }

        return winningLotto;
    }

}
