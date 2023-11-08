package lotto.View;

import static lotto.util.Verify.verifyBonusNumber;
import static lotto.util.Verify.verifyWinningNumbersStringToList;
import static lotto.util.Verify.verifyAmount;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;

public class InputView {
    public static final Integer PURCHASE_UNIT = 1000;
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    public InputView(){}

    public static Integer getHowMuchLottoWillYouBuy(){
        boolean condition = TRUE;
        Integer value = 0;
        do{
            try{
                String input = Console.readLine();
                value = verifyAmount(input);
                condition = FALSE;
            }
            catch (IllegalArgumentException e){
                condition = TRUE;
            }
        } while(condition);

        return value / PURCHASE_UNIT;
    }

    public static Lotto getWinningLottoNumbers(){
        boolean condition = TRUE;
        List<Integer> numbers = new ArrayList<>();
        do{
            try{
                String input = Console.readLine();
                numbers = verifyWinningNumbersStringToList(input);
                condition = FALSE;
            }
            catch (IllegalArgumentException e){
                condition = TRUE;
            }
        } while(condition);

        return new Lotto(numbers);
    }

    public static Integer getBonusNumber(){
        boolean condition = TRUE;
        Integer number = 0;
        do{
            try{
                String input = Console.readLine();
                number = verifyBonusNumber(input);
                condition = FALSE;
            }
            catch (IllegalArgumentException e){
                condition = TRUE;
            }
        } while(condition);

        return number;
    }
}
