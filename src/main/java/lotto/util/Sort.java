package lotto.util;

import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

public class Sort {
    public static ArrayList<Integer> sortWinningNumber(Set<Integer> winnerNumber) {
        ArrayList<Integer> winnerNumbers = winnerNumber.stream()
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(winnerNumbers);
        return winnerNumbers;
    }
}
