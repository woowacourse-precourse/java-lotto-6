package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

public class SortingList {
    public List<Integer> sortList(List<Integer> number) {
        return number.stream().sorted().collect(Collectors.toList());
    }
}
