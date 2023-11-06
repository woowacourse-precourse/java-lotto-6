package lotto.view;

import lotto.enums.Messages;
import lotto.model.Lotto;
import lotto.utils.Order;

import java.util.List;

public class OutputView {
    public static void printOneLotto(Lotto lotto){
        List<Integer> numbers = Order.orderNumbers(lotto.getNumbers());
        System.out.println(numbers.toString());
    }

    public static void printLottos(List<Lotto> lottos){
        System.out.println();
        System.out.printf("%d%s\n",lottos.size(), Messages.OUTPUT_BUY_MESSAGE.getMessage());
        for(Lotto lotto : lottos){
            printOneLotto(lotto);
        }
    }

    public static void printAskWinNumbers(){
        System.out.println();
        System.out.println(Messages.INPUT_WINNUMER_MESSAGE.getMessage());
    }
}
