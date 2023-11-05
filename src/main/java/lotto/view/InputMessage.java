package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    public static String inputPurchase(){
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public static String inputPrizeLotto(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try{
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e){
            ExceptionMessage.wrongLottoException();
            return 0;
        }
    }
}
