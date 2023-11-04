package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.UserLotto;
import lotto.View.PrintView;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    ExceptionController exceptionController;
    PrintView view;

    public InputController(){
        exceptionController = new ExceptionController();
        view = new PrintView();
    }

    public int inputMoney(){
        view.inputMoneyPrint();
        String temp = Console.readLine();
        System.out.println("");
        try {
            exceptionController.moneyException(temp);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 숫자이어야 힙니다.");
            return inputMoney();
        }catch(IllegalStateException e){
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어떨어져야 합니다.");
            return inputMoney();
        }
        int money = Integer.parseInt(temp);
        return money;
    }

    public UserLotto inputNumbers(){
        view.inputNumbersPrint();
        List<Integer> numbers = new ArrayList<>();

        String[] input = Console.readLine().split(",");
        System.out.println("");
        try{
            exceptionController.numbersException(input);
        }catch(IllegalStateException e){
            System.out.println("[ERROR] 당첨번호는 6개이어야 합니다.");
            return inputNumbers();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 당첨번호는 1과 45사이의 숫자 이어야 합니다.");
            return inputNumbers();
        }
        for(String s : input)
            numbers.add(Integer.parseInt(s));

        numbers.add(inputBonusNumber());
        UserLotto lotto = new UserLotto(numbers);

        return lotto;
    }

    public int inputBonusNumber(){
        view.inputBonusNumberPrint();
        String bonus_number = Console.readLine();
        System.out.println("");
        try {
            exceptionController.bonusNumberException(bonus_number);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호는 숫자이어야 합니다.");
            return inputBonusNumber();
        }catch(IllegalStateException e){
            System.out.println("[ERROR] 보너스 번호는 1에서 45사이의 숫자이어야 합니다.");
            return inputBonusNumber();
        }

        return Integer.parseInt(bonus_number);
    }
}
