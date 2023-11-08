package lotto.view;

import static lotto.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;

public class View {

    public String inputBuyingMoney(){
        System.out.println(INPUT_BUYING_NUM_MESSEAGE);
        return Console.readLine();
    }
    public void inputExceptionMessage(){
        System.out.println(INPUT_BUYING_NUM_EXCEPTION_MESSAGE);
    }

    public void outputExceptionMessage(){
        System.out.println(OUTPUT_CORRECT_NUM_EXCEPTION_MESSAGE);
    }
    public void BuyingLottoOutput(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public String inputBonusNum(){
        System.out.println((INPUT_BONUS_NUM_MESSAGE));
        return Console.readLine();
    }

    public String inputCorrectNUM(){
        System.out.println(INPUT_CORRECT_NUM_MESSAGE);
        return Console.readLine();
    }

}
