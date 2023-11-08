package lotto;

import lotto.model.Model;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;
import net.bytebuddy.matcher.StringMatcher;
import org.mockito.internal.matchers.Null;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int numberOfLottos = -1, bonusNumber = -1;
        List<Integer> winningNumbers = null;
        List<Lotto> lottos;
        Model model;

        while (numberOfLottos == -1) {
            try {
                ConsoleOutput.buyInfoMessage();
                numberOfLottos = ConsoleInput.buy();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        ConsoleOutput.howMuchLottoMessage(numberOfLottos);

        lottos = Lotto.generateLottos(numberOfLottos);
        ConsoleOutput.showLottos(lottos);

        while (winningNumbers == null) {
            try {
                ConsoleOutput.winningNumberInfoMessage();
                winningNumbers = ConsoleInput.winningNumbers();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }

        while (bonusNumber == -1) {
            try {
                ConsoleOutput.bonusNumberInfoMessage();
                bonusNumber = ConsoleInput.bonusNumber();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }

        /*
            결과를 포함한 모델 생성.
         */
        model = new Model(lottos, winningNumbers, bonusNumber);

        ConsoleOutput.resultMessage(model);
    }
}
