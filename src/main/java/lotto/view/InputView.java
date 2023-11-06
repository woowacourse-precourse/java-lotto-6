package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;

public class InputView {
    public static String getInput(String type){
        String input_text = Console.readLine();
        switch(type){
            case "number":
                try{
                    Integer.parseInt(input_text);
                }
                catch (NumberFormatException ex){
                    throw new InputMismatchException("[ERROR] 잘못된 타입을 입력하셨습니다.");
                }
            case "text":
            default:
                break;
        }
        return input_text;
    }
}
