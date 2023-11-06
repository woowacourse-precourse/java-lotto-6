package lotto.view;

import lotto.Constants;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printQuantity(int quantity) {
        System.out.println(quantity+Constants.QUANTITY_RESULT);
    }

    public static void printRandomLotto(List<List<Integer>> randomLotto) {
        for(List<Integer> numbers : randomLotto) {
            String numberStr = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
            System.out.println(numberStr);
        }
    }

}
