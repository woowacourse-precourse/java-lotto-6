package lotto.view;

import lotto.Constant.ErrorMessageConstant;
import lotto.Constant.InputConstant;

public class ErrorMessageView {
    public static void notInteger(){
        System.out.println(ErrorMessageConstant.NOT_INTEGER);
    }
    public static void illegalValueMessage(String e){
        System.out.println(e);
    }
}
