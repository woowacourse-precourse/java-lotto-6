package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public static String getPurchaseAmount() {
        String PurchaseAmount;

        try {
            PurchaseAmount = Console.readLine();
        } catch (NoSuchElementException noSuchElementException){
            throw new IllegalArgumentException("[ERROR] 구입금액에 값이 안들어왔습니다");
        }
        return PurchaseAmount;
    }
}
