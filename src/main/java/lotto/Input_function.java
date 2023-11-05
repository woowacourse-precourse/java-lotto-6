package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input_function {
    public int num = 0; 
    public int get_money() {

        try{
            System.out.println("구입금액을 입력해 주세요.");
            String input_str = Console.readLine();
            num = Integer.parseInt(input_str);

            return num;
        }
        catch(NumberFormatException nfe) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.", nfe);
        }

    }
    
}
