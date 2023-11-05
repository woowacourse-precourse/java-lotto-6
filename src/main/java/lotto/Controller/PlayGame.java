package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.*;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.Arrays;
import java.util.List;

public class PlayGame {
    Setting setting = new Setting();
    Lotto winningNumbers;
    UserLotto userLottos = new UserLotto();
    int bonusNumber ;

    public void play() {
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = setting.purchase_amount() / 1000;

        System.out.println("\n" + lottoAmount + PrintOutput.NUMBER_OF_LOTTO);
        List<Lotto> randomLottoNumbers = userLottos.userLottosCreate(lottoAmount);
        for (Lotto numbers : randomLottoNumbers) {
            System.out.println(numbers.toString());
        }

        System.out.println("\n" + PrintInput.WINNING_NUMBER);
        input_lottoNumbers();

        System.out.println("\n" + PrintInput.BONUS_NUMBER);
        input_bonusNumber();

        Result winningData = new Result();

        for (Lotto userLottoNumbers : randomLottoNumbers){
            int[] matchNumber = winningNumbers.matchNumber(userLottoNumbers, bonusNumber);

            winningData.winningResult(matchNumber[0], matchNumber[1]);
        }
        winningData.printResult();
    }

    public void input_lottoNumbers() {
        try {
            String inputNumbers = Console.readLine();
            winningNumbers = new Lotto(setting.stringToList(inputNumbers));
        } catch (IllegalArgumentException e) {
            input_lottoNumbers();
        }
    }

    public void input_bonusNumber() {
        try{
            String input = Console.readLine();
            bonusNumber = setting.inputToInt(input);
            setting.checkNumber(bonusNumber);
            winningNumbers.check_bonusNumber(bonusNumber);
        }catch (IllegalArgumentException e){
            input_bonusNumber();
        }
    }
}
