package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Setting;
import lotto.View.PrintInput;
import lotto.View.PrintOutput;

import java.util.List;

public class PlayGame {
    Setting setting = new Setting();

    public void play(){
        System.out.println(PrintInput.INPUT_MONEY);
        int lottoAmount = setting.purchase_amount()/1000;

        System.out.println("\n" + lottoAmount + PrintOutput.NUMBER_OF_LOTTO);
        System.out.println("\n" + PrintOutput.RESURLT_LOTTO);

        List<List<Integer>> randomLottoNumbers = setting.createLottoNumber(lottoAmount);
        for (List<Integer> numbers : randomLottoNumbers){
            System.out.println(numbers);
        }
    }
}
