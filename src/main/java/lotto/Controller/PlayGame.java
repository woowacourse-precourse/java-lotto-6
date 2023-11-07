package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.*;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    InputData inputData = new InputData();
    UserLotto userLottos = new UserLotto();
    Result winningData = new Result();
    Lotto winningNumbers;

    public void play() {
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = inputData.purchase_amount() / 1000;

        PrintOutput.printAmount(lottoAmount);
        List<Lotto> randomLottoNumbers = userLottos.userLottosCreate(lottoAmount);
        PrintOutput.printUserLotto(randomLottoNumbers);

        System.out.println("\n" + PrintInput.WINNING_NUMBER);
        winningNumbers = inputData.getWinningNumbers();

        System.out.println("\n" + PrintInput.BONUS_NUMBER);
        int bonusBall = inputData.getBonusNumber();

        for (Lotto userLottoNumbers : randomLottoNumbers) {
            int matchNumber = winningNumbers.matchNumber(userLottoNumbers);
            boolean checkBonusBall = userLottoNumbers.checkBonusBall(bonusBall);

            winningData.winningResult(matchNumber, checkBonusBall);
        }

        winningData.printResult(lottoAmount * 1000);
    }
}
