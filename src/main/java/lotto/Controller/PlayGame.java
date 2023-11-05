package lotto.Controller;

import lotto.Model.*;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    Setting setting = new Setting();
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
        matchResult(randomLottoNumbers, setting.getBonusNumber());

        winningData.printResult(lottoAmount * 1000);
    }

    public void matchResult(List<Lotto> randomLottoNumbers, int bonusNumber) {
        for (Lotto userLottoNumbers : randomLottoNumbers) {
            int[] matchNumber = winningNumbers.matchNumber(userLottoNumbers, bonusNumber);

            winningData.winningResult(matchNumber[0], matchNumber[1]);
        }
    }
}
