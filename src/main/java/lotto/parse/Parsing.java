package lotto.parse;

public class Parsing {
    public static int stringToInt(String inputValue){
        return Integer.parseInt(inputValue);
    }
    public static void isDivisible(int inputValue){
        if(inputValue%1000 != 0){
            throw new IllegalArgumentException();
        }
    }
}
