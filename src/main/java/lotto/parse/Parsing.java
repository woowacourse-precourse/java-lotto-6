package lotto.parse;
import java.util.*;
import java.util.stream.Collectors;

public class Parsing {
    public static int stringToInt(String inputValue){
        return Integer.parseInt(inputValue);
    }
    public static int isDivisible(int inputValue){
        if(inputValue%1000 != 0){
            throw new IllegalArgumentException();
        }
        System.out.println();
        return inputValue/1000;
    }

    public static List<Integer> makeList(String inputValue){
        List<Integer> lottoList = new ArrayList<>();
        String[] split = inputValue.split(",");
        lottoList = Arrays.stream(split).map(s -> stringToInt(s)).collect(Collectors.toList());
        return lottoList;
    }



}
