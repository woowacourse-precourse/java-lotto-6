package lotto.Controller;

import lotto.Model.*;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    InputData setting = new InputData();
    UserLotto userLottos = new UserLotto();
    Result winningData = new Result();
    Lotto winningNumbers;

    public void play() {
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = setting.purchase_amount() / 1000;

        PrintOutput.printAmount(lottoAmount);
        List<Lotto> randomLottoNumbers = userLottos.userLottosCreate(lottoAmount);
        PrintOutput.printUserLotto(randomLottoNumbers);

        System.out.println("\n" + PrintInput.WINNING_NUMBER);
        winningNumbers = setting.getWinningNumbers();

        System.out.println("\n" + PrintInput.BONUS_NUMBER);
        int bonusBall = setting.getBonusNumber();

        for (Lotto userLottoNumbers : randomLottoNumbers) {
            int matchNumber = winningNumbers.matchNumber(userLottoNumbers);

            winningData.winningResult(matchNumber, userLottoNumbers.checkBonusBall(bonusBall));
        }

        winningData.printResult(lottoAmount * 1000);
    }
}
