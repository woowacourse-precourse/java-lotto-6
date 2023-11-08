package lotto;

import java.util.ArrayList;
import java.util.List;

public class UserInputProcessor {
    public static int purchaseAmountValidator(String userInput) {
        int purchaseAmount = 0;
        try{
            purchaseAmount = Integer.parseInt(userInput);
        }catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다. 숫자를 입력해주세요.");
        }
        return purchaseAmount;
    }
}
