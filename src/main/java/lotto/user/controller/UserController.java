package lotto.user.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

import lotto.user.view.UserView;
import lotto.util.convert.ConvertUtil;
import lotto.util.validate.UserValidate;

public class UserController {
    private UserController(){ }

    private static final UserController instance = new UserController();

    public static UserController getInstance(){
        return instance;
    }

    public int purchaseInput(){
        UserView.inputPurchase();
        String input = readLine();
        int temp = 0;
        try{
            temp = ConvertUtil.stringToInt(input);
            UserValidate.isTousand(temp);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.purchaseInput();
        }
        return temp;
    }

    public List<Integer> lottoNumberInput(){
        UserView.inputLottoNumber();
        String input = readLine();
        List<Integer> temp = null;
        try{
            temp = ConvertUtil.stringToIntArr(input);
            UserValidate.checkNumberCount(temp);
            UserValidate.checkDuplicate(temp);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.lottoNumberInput();
        }
        return temp;
    }

    public int lottoBonusNumberInput(){
        UserView.inputLottoBonusNumber();
        String input = readLine();
        int temp = 0;
        try{
            temp = ConvertUtil.stringToInt(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.lottoBonusNumberInput();
        }
        return temp;
    }



}
