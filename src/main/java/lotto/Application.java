package lotto;

import java.util.*;

public class Application {
    static int price = 1000;

    public static void main(String[] args) {
        int amountOfMoney = InputRequirement.inputLottoAmount();

        List<Lotto> allLotto = LottoGenerator.generateLottos(amountOfMoney / price);
        LottoGenerator.printGeneratedLottos(allLotto, amountOfMoney / price);

        Lotto winningLotto = InputRequirement.inputWinningNumbers();

        int bonusNumber = InputRequirement.inputBonusNumber();

        List<Integer> result = WinResult.getResult(allLotto, winningLotto, bonusNumber);
        WinResult.printStatistic(result, amountOfMoney);
    }
}
