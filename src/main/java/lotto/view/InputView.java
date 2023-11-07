package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static lotto.util.Phrase.InputPhrase.INPUT_COST;
import static lotto.util.Phrase.InputPhrase.INPUT_ORIGINALNUMBER;
import static lotto.util.Phrase.InputPhrase.INPUT_BONUS;

public class InputView {
//    private enum InputPhrase{
//        INPUT_COST("구입금액을 입력해 주세요."),
//        INPUT_NUMBER("당첨 번호를 입력해 주세요."),
//        INPUT_BONUS("보너스 번호를 입력해 주세요.");
//        private final String message;
//
//        InputPhrase(String message){
//            this.message = message;
//        }
//    }

    public int inputCost(){
        System.out.println(INPUT_COST.printMessage());
        String cost = Console.readLine();
        //exception
        return Integer.parseInt(cost);
    }

    public List<Integer> inputOriginalNumber(){
        System.out.println(INPUT_ORIGINALNUMBER.printMessage());
        String number = Console.readLine();
        //exception
        //return number;
        return List.of(0, 0);
    }


    public int inputBonus(){
        System.out.println(INPUT_BONUS.printMessage());
        String bonus = Console.readLine();
        //exception
        //return bonus;
        return Integer.parseInt(bonus);
    }

}
