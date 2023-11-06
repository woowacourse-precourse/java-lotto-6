package lotto.user.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import lotto.util.convert.ConvertUtil;

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
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            this.purchaseInput();
        }
        return temp;
    }



}
