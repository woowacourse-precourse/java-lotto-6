package lotto.utils;

import java.util.HashSet;
import java.util.List;

public class Checker {

    public static boolean isUnique(List<Integer> integerList) {
        return new HashSet<>(integerList).size() == integerList.size();
    }

    public static boolean isPositive(Integer number) {
        return number > 0;
    }

    public static boolean is1k(Integer number){
        return number % 1000 == 0;
    }
}
