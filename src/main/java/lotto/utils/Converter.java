package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class Converter {

    private Converter(){

    }
    public static Lotto stringToLotto(String inputValue){
        List<Integer> numbers = stringListToIntegerList(stringToList(inputValue));
        return new Lotto(numbers);
    }

    public static List<Integer> stringListToIntegerList(List<String> inputValue){
        return inputValue.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> stringToList(String inputValue){
        return new ArrayList<>(List.of(inputValue.split(",")));
    }
}
