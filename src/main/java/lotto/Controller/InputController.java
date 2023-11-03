package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import java.util.ArrayList;
import java.util.List;

public class InputController {

    ExceptionController exceptionController;

    public InputController(){
        exceptionController = new ExceptionController();
    }

    public int inputMoney(){
        String temp = Console.readLine();
        try {
            exceptionController.moneyException(temp);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 숫자이어야 힙니다.");
            inputMoney();
        }catch(IllegalStateException e){
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어떨어져야 합니다.");
            inputMoney();
        }
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public Lotto inputNumbers(){
        List<Integer> numbers = new ArrayList<>();

        String[] input = Console.readLine().split(",");
        try{
            exceptionController.numbersException(input);
        }catch(IllegalStateException e){
            System.out.println("[ERROR] 당첨번호는 6개이어야 합니다.");
            inputNumbers();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 당첨번호는 숫자이어야 합니다.");
            inputNumbers();
        }
        for(String s : input)
            numbers.add(Integer.parseInt(s));

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public void inputBonusNumber(){
        String
    }
}
