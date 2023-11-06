package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class StringToList {
    private List<Integer> valueToReturn = new ArrayList<>();

    StringToList(String input){
        String[] splitNumbers = input.split(",");
        for(String splitNumber : splitNumbers){
            StringToInt changedNumber = new StringToInt(splitNumber);
            valueToReturn.add(changedNumber.getInteger());
        }
    }

    public List<Integer> getInteger(){
        return valueToReturn;
    }
}
