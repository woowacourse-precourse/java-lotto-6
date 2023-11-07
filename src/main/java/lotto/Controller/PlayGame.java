package lotto.Controller;

import lotto.DTO.Result;
import lotto.Model.*;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    InputData inputData = new InputData();
    UserLotto userLottos = new UserLotto();
    Result winningData = new Result();
    LottoResult lottoResult = new LottoResult(winningData);
    Lotto winningNumbers;
    List<Lotto> randomLottoNumbers;

    public void play() {
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = inputData.purchase_amount() / 1000;

        PrintOutput.printAmount(lottoAmount);
        randomLottoNumbers = userLottos.userLottosCreate(lottoAmount);
        PrintOutput.printUserLotto(randomLottoNumbers);

        System.out.println("\n" + PrintInput.WINNING_NUMBER);
        winningNumbers = inputData.getWinningNumbers();

        System.out.println("\n" + PrintInput.BONUS_NUMBER);
        int bonusBall = inputData.getBonusNumber();

        storeResult(bonusBall);
        lottoResult.printResult(lottoAmount * 1000);
    }

    private void storeResult(int bonusBall){
        for (Lotto userLottoNumbers : randomLottoNumbers) {
            int matchNumber = winningNumbers.matchNumber(userLottoNumbers);
            boolean checkBonusBall = userLottoNumbers.checkBonusBall(bonusBall);

            Winning winning = Winning.result(matchNumber, checkBonusBall);
            winningData.winningResult(winning);
        }
    }
}
