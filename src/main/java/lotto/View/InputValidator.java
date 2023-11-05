package lotto.View;

public class InputValidator {
    public static void exceptInsertInteger(String inputValue){
        if(validateNumber(inputValue)){
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        };
    }
    private static boolean validateNumber(String inputData){
        char charAt;
        for(int i=0; i< inputData.length();i++){
            charAt = inputData.charAt(i);
            if(Character.isDigit(charAt) == false){
                return true;
            }
        }
        return false;
    }
}
