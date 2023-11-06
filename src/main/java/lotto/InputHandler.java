package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public Integer  readCost() {
        System.out.println("구입 금액을 입력해 주세요.");
        while(true) {
            try {
                String input = Console.readLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
    }
    
    
    
}
