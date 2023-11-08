package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.RandomLottoGenerator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = ConsoleInput.inputAmount();
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(amount);
        Lottos lottos = randomLottoGenerator.generate();
        ConsoleOutput.printAllRandomsLottos(lottos);
        Lotto lotto = ConsoleInput.inputPrizeNumbers();
        int bonusNumber = ConsoleInput.inputBonusNumber();
    }
}
