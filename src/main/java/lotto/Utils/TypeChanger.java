package lotto.Utils;

import java.util.ArrayList;
import java.util.List;


public class TypeChanger {
    private String input;
    public List<Integer> toIntegerList(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] splitInput = input.split(",");
        for(String splited: splitInput){
            numbers.add(Integer.parseInt(splited));
        }
        return numbers;
    }


}
