package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.data.Purchasing;
import lotto.data.Statics;
import lotto.data.Winning;
import lotto.domain.CalculateStatistics;
import lotto.presentation.Input;
import lotto.presentation.Output;

public class Application {
    public static void main(String[] args) {
        start();
    }
    static void start(){
        Input input = new Input();
        Output output = new Output();
        Statics statics = new Statics(5);

        String purchasePrice = input.inputPurchasePrice();

        Purchasing purchasing = new Purchasing(Integer.parseInt(purchasePrice));

        output.printPurchasedLottos(purchasing.getLottos());
        String[] winngingNumber = input.inputWinningNumber();
        String bonusNumber = input.inputBonusNumber();
        List<Integer> integerList = new ArrayList<>();
        for (String str : winngingNumber) {
            try {
                // Parse each string to an integer and add it to the list
                integerList.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                // Handle the case where the string is not a valid integer
                e.printStackTrace();
            }
        }

        Winning winning = new Winning(integerList, Integer.parseInt(bonusNumber));

        CalculateStatistics.calculateStatistics(purchasing.getLottos(), winning, statics);
        output.printMultipleWinningStatics(statics);
    }
}
