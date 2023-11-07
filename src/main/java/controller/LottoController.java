package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.User;
import service.LottoService;
import validate.Validator;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();

    public void startLotto(){
        int price = AskPrice();

        User user = new User(price);
        Lotto winning_numbers = new Lotto();


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

    public List<Integer> AskWinningNumbers(){
        List<Integer> winningNumberList = new ArrayList<>();

        inputView.printWinningNumbers();
        Console.readLine()

    }

    public
}
