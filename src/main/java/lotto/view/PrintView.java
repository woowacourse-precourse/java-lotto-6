package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PrintView {
    private static final String Input_Lotto_Buy = "구입금액을 입력해 주세요.";
    private static final String Output_Lotto_Buy = "개를 구매했습니다.";
    private static final String Input_Bonus_Number = "보너스 번호를 입력해 주세요.";
    private static final String Input_Winning_Number = "당첨 번호를 입력해 주세요.";
    public static String Input_Lotto_Buy(){
        System.out.println(Input_Lotto_Buy);
        return Console.readLine();
    }

    public static void Output_Lotto_Buy(int price){
        System.out.println();
        System.out.println(price + Output_Lotto_Buy);
    }

    public static String Input_Winning_Number(){
        System.out.println();
        System.out.println(Input_Winning_Number);
        return Console.readLine();
    }

    public static String Input_Bonus_Number(){
        System.out.println();
        System.out.println(Input_Bonus_Number);
        return Console.readLine();
    }
}
