package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmountGenerator;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumbersGenerator;
import lotto.io.OutputHandler;

public class Application {
    static int amount;
    static List<Lotto> lottos;

    static Lotto winningNumbers;


    public static void main(String[] args) {
        amount = LottoAmountGenerator.generateLottoAmount();
        lottos = LottoGenerator.issueLotto(amount);

        OutputHandler.printLottoAmount(amount);
        OutputHandler.printLottos(lottos);

        winningNumbers = WinningNumbersGenerator.generateWinningNumbers();
    }
}
