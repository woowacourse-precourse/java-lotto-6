package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.view.View;
import lotto.util.Validator;


public class Game {
    private static final int LOTTO_PRICE = 1000;

    private int money;
    private View view;
    private Validator validator;

    public Game(){
        view = new View();
        validator = new Validator();
    }

    public void play(){
        getMoney();
    }

    private void getMoney(){
        money = Integer.parseInt(inputMoney());
    }

    private String inputMoney(){
        view.request_InputMoney();
        return check_ValidationInputMoney(Console.readLine());
    }

    private String check_ValidationInputMoney(String input){
        try{
            validator.check_InputMoney(input);
            return input;
        }catch(IllegalArgumentException e){
            view.print_Exception(e.getMessage());
            return inputMoney();
        }
    }

}
