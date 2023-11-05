package lotto.Model;

public class StringToInt {
    private int valueToReturn;

    StringToInt(String input){
        valueToReturn = Integer.parseInt(input);
    }

    public int getInteger(){
        return valueToReturn;
    }
}