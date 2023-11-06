package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    
    public Integer readCost(String input) {
        try {
            Integer cost = Integer.parseInt(input);
            return divideByThousand(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.", e);
        }
    }
    
    private Integer divideByThousand(Integer cost) {
        if(cost % 1000 == 0) {
            return cost;
        }
        throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 숫자를 입력해야 합니다.");
    }
    
    
    
}
