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

    public static void stringToInt(List<String> numbers) {
        numbers.stream()
                .forEach((number) -> Integer.parseInt(number));
    }

    public static List<String> lottoToString(Lotto lotto) {
        List<String> numbers = lotto.getNumbers()
                .stream().map(String::valueOf)
                .collect(Collectors.toList());
        return numbers;
    }

    public static String deleteSpace(String input){
        String replaceValue = input.replace(" ", "");
        return replaceValue;
    }

}
