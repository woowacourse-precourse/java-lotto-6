package lotto.domain;
import camp.nextstep.edu.missionutils.Console;
public class InputAmount {
    private static final int Lotto_Cost = 1000;
    private final int Lottos = 0;


    public static int Input_Lotto_Amount() {
        String amount = Console.readLine();
        boolean flag = Amount_Type_Check(amount);
        if(flag == false){
            return Input_Lotto_Amount();
        }
        return Integer.parseInt(amount);
    }
    private static boolean Amount_Type_Check(String amount){
        try{
            Integer.parseInt(amount);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }



}
