package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.View;

public class Input {

    public static PurchaseAmount purchaseAmount(){
        while(true){
            View.requestPurchaseAmount();
            try{
                String input = readLine();
                Validate.trim(input);
                Validate.number(input);

                return PurchaseAmount.from(stringToInt(input));
            }catch (IllegalArgumentException e){
                View.errorMessage(e.getMessage());
            }
        }
    }

    public static BonusNumber bonusNumber(Lotto winningLotto){
        while(true){
            View.requestBonusNumber();
            String input = readLine();
            try{
                Validate.trim(input);
                Validate.number(input);

                return BonusNumber.from(winningLotto, stringToInt(input));
            }catch (IllegalArgumentException e){
                View.errorMessage(e.getMessage());
            }
        }
    }

    public static Lotto winningNumbers(){
        while(true){
            View.requestWinningNumber();
            try {
                String input = readLine();
                Validate.trim(input);

                String[] inputs = input.split(",", -1);
                Validate.commaBeforeAndAfter(inputs);
                Validate.number(inputs);

                return new Lotto(stringArrToIntegerList(inputs));
            } catch (IllegalArgumentException e) {
                View.errorMessage(e.getMessage());
            }
        }
    }

    private static String readLine(){
        return Console.readLine();
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private static List<Integer> stringArrToIntegerList(String[] inputs) {
        return Arrays.stream(inputs)
                .map(Integer::parseInt)
                .toList();
    }
}
