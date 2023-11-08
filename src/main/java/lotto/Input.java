package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = Console.readLine();
        int result;
        try{
            Validator.buyCheck(inputText);
            result = Integer.parseInt(inputText) / 1000;
        }catch (IllegalArgumentException e){
            result = buyLotto();
        }
        return result;
    }
}
