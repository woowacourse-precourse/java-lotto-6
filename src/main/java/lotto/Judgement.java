package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Judgement {
    public Set<Integer> commonNumber(List<Integer> winNumber, List<Integer> randomNumber) {
        Set<Integer> commonNumber = winNumber.stream().filter(randomNumber::contains).collect(Collectors.toSet());
        return commonNumber;
    }
}
