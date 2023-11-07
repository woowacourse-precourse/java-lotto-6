package lotto.user.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

import lotto.util.convert.ConvertUtil;
import lotto.util.validate.UserValidate;

public class UserController {
    private UserController(){ }

    private static final UserController instance = new UserController();

    public static UserController getInstance(){
        return instance;
    }

    public int purchaseInput(){
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



}
