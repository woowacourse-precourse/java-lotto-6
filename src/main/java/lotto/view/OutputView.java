package lotto.view;

import lotto.model.Lotto;
import lotto.utils.Order;

import java.util.List;

public class OutputView {
    public static void printOneLotto(Lotto lotto){
        List<Integer> numbers = Order.orderNumbers(lotto.getNumbers());
        System.out.println(numbers.toString());
    }
}
