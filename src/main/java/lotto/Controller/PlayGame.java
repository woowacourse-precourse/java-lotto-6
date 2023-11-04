package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.Setting;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    Setting setting = new Setting();
    Lotto winningNumbers;
    int bonusNumber ;

    public void play() {
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = setting.purchase_amount() / 1000;

        System.out.println("\n" + lottoAmount + PrintOutput.NUMBER_OF_LOTTO);
        System.out.println("\n" + PrintOutput.RESURLT_LOTTO);

        List<List<Integer>> randomLottoNumbers = setting.createLottoNumber(lottoAmount);
        for (List<Integer> numbers : randomLottoNumbers) {
            System.out.println(numbers);
        }

        System.out.println("\n" + PrintInput.WINNING_NUMBER);
        input_lottoNumbers();

        System.out.println("\n" + PrintInput.BONUS_NUMBER);
        input_bonusNumber();

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
