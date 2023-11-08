package lotto;

public class ErrorValidate {
    public static void inputNumberLimit(int number) {
        if (number<1 || number>46) {
            throw new IllegalArgumentException();
        }
    }
    public static void isNumberFormat(String input){
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException();
        }
    }

}
