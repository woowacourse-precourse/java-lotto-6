package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.PrizeLotto;
import lotto.util.GameUtil;
import lotto.view.View;
import lotto.util.Validator;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Game {
    private static final int LOTTO_PRICE = 1000;

    private View view;
    private Validator validator;

    private int money;
    private List<Lotto> purchasedLotto;
    private PrizeLotto prizeLotto;


    public Game(){
        view = new View();
        validator = new Validator();
    }

    public void play(){
        getMoney();

        purchaseLotto(money/LOTTO_PRICE);

        getPrizeLotto();

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
        view.print_PurchasedLottoNumbers(purchaseNumber);

        List<Lotto> createdLotto= new ArrayList<>();

        for(int i=0;i<purchaseNumber;i++){
            createdLotto.add(GameUtil.createLotto());
        }

        purchasedLotto = createdLotto;

        view.print_purchasedLotto(purchasedLotto);
    }

    private void getPrizeLotto(){
        List<Integer> inputWinLotto = getIntegerWinLotto(inputWinLotto());

        Lotto winLotto = new Lotto(inputWinLotto);

        int bonusNum = getBonusNum();

        prizeLotto = new PrizeLotto(winLotto,bonusNum);

    }

    private List<Integer> getIntegerWinLotto(String input){
        List<String> winLotto = GameUtil.converseStringToStringList(input);

        return GameUtil.converseStringListToIntegerList(winLotto);
    }

    private String inputWinLotto(){
        view.request_InputWinLottoNumbers();

        return check_ValidationInputWinLotto(Console.readLine());
    }

    private String check_ValidationInputWinLotto(String input){
        try{
            validator.check_InputWinLotto(input);
            return input;
        }catch(IllegalArgumentException e){
            view.print_Exception(e.getMessage());
            return inputWinLotto();
        }
    }

    private int getBonusNum(){
        return Integer.parseInt(inputBonusNum());
    }

    private String inputBonusNum(){
        view.request_InputBonusNumbers();

        return check_ValidationInputBonusNum(Console.readLine());
    }

    private String check_ValidationInputBonusNum(String input){
        try{
            validator.check_BonusNum(input);
            return input;
        }catch(IllegalArgumentException e){
            view.print_Exception(e.getMessage());
            return inputBonusNum();
        }
    }

}
