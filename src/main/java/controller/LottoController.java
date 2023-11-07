package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.User;
import validate.Validator;
import view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void startLotto(){
        int price = AskPrice();
        Lotto winning_numbers = new Lotto();
        User user = new User(price);



    }
    public int AskPrice(){
        inputView.printAskPrice();
        return inputPrice();
    }
    public int inputPrice(){
        int my_price;
        try{
            my_price = validator.validatePrice(Console.readLine());
        }catch (NullPointerException e){
            return AskPrice();
        }catch (IllegalArgumentException e){
            return AskPrice();
        }
        return my_price;
    }

    public
}
