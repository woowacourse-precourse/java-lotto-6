package lotto.View;

import static lotto.util.Verify.verifyWinningNumbersStringToList;
import static lotto.util.Verify.verifyAmount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Model.Lotto;

public class InputView {
    public static final Integer PURCHASE_UNIT = 1000;

    public InputView(){}

    public static Integer getHowMuchLottoWillYouBuy() throws IllegalArgumentException{
        String input = Console.readLine();
        Integer value = verifyAmount(input);
        return value / PURCHASE_UNIT;
    }

    public static Lotto getWinningLottoNumbers(){
        String input = Console.readLine();
        List<Integer> numbers = verifyWinningNumbersStringToList(input);
        return new Lotto(numbers);
    }

    public static Integer getBonusNumber(){
        String input = Console.readLine();
        return Integer.parseInt(String.valueOf(input));
    }
}
