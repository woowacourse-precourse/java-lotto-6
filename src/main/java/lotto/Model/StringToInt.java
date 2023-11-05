package lotto.Model;

public class StringToInt {
    private int tmp;

    StringToInt(String input){
        tmp = Integer.parseInt(input);
    }

    public int getInteger(){
        return tmp;
    }
}