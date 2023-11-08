package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public static String getPurchaseAmount() {
        String purchaseAmount;

        try {
            purchaseAmount = Console.readLine();
        } catch (NoSuchElementException noSuchElementException){
            throw new IllegalArgumentException("[ERROR] 구입금액에 값이 안들어왔습니다");
        }
        return purchaseAmount;
    }

    public static String getWinningLottoNumber() {
        String winningLottoNumber;

        try {
            winningLottoNumber = Console.readLine();
        } catch (NoSuchElementException noSuchElementException){
            throw new IllegalArgumentException("[ERROR] 당첨번호에 값이 안들어왔습니다");
        }
        return winningLottoNumber;
    }

    public static String getWinningBonusNumber() {
        String winningBonusNumber;

        try {
            winningBonusNumber = Console.readLine();
        } catch (NoSuchElementException noSuchElementException){
            throw new IllegalArgumentException("[ERROR] 보너스번호에 값이 안들어왔습니다");
        }
        return winningBonusNumber;
    }
}
