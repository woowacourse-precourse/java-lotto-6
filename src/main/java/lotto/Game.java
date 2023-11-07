package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.util.GameUtil;
import lotto.view.View;
import lotto.util.Validator;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private static final int LOTTO_PRICE = 1000;

    private View view;
    private Validator validator;

    private int money;
    private List<Lotto> purchasedLotto;


    public Game(){
        view = new View();
        validator = new Validator();
    }

    public void play(){
        getMoney();

        view.print_PurchasedLottoNumbers(money/LOTTO_PRICE);
        purchaseLotto(money/LOTTO_PRICE);
        view.print_purchasedLotto(purchasedLotto);

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

    private void purchaseLotto(int purchaseNumber){

        List<Lotto> createdLotto= new ArrayList<>();

        for(int i=0;i<purchaseNumber;i++){
            createdLotto.add(GameUtil.createLotto());
        }

        purchasedLotto = createdLotto;
    }

}
