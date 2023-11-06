package lotto.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order {
    public static List<Integer> orderNumbers(List<Integer> numbers){
        List<Integer> orderNumbers = new ArrayList<>(numbers);
        orderNumbers.sort(Comparator.naturalOrder());
        return orderNumbers;
    }
}
