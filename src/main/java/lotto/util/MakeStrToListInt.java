package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeStrToListInt {
    public static List<Integer> getStrToListInt(String numbers){
        return Arrays.stream(numbers.split(","))
                .map(Integer::valueOf) 
                .collect(Collectors.toList());
    }
}
