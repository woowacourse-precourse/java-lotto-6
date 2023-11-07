package lotto.view;

import static lotto.service.InputException.validBonus;
import static lotto.service.InputException.validLotto;
import static lotto.service.InputException.validMoney;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.MessageConstant;

public class InputView {
    public int inputMoney(){
        System.out.println(MessageConstant.BUY_LOTTO_MESSAGE.getMessage());

        while(true){
            try{
                String input = Console.readLine();
                return validMoney(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputNumbers(){
        System.out.println();
        System.out.println(MessageConstant.LOTTO_NUMBER_MESSAGE.getMessage());
        while(true){
            try{
                String input = Console.readLine();
                return validLotto(input);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonus(List<Integer> numbers){
        System.out.println();
        System.out.println(MessageConstant.BONUS_MESSAGE.getMessage());
        while(true){
            try{
                String input = Console.readLine();
                return validBonus(input, numbers);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
