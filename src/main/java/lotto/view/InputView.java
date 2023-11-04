package lotto.view;

import camp.nextstep.edu.missionutils.Console;


import static lotto.domain.Message.INPUT_MONEY;


public class InputView {

    public static int inputMoney(){
        System.out.println(INPUT_MONEY);
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }




    public static boolean checkName(String name) {
        if(name.length() <= 5) return true;
        else throw new IllegalArgumentException("올바르지 않은 입력입니다.");
    }
    

}
