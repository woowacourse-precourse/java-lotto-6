package lotto.View;

public class InputValidator {
    public static void validateInsertInteger(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException("입력이 없습니다");
        }

        if(isNumber(inputValue)){
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        };

    }

    public static void validateInsertString(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException("[ERROR] 입력이 없습니다.");
        }
    }

    private static boolean isNumber(String inputData){
        char charAt;
        for(int i=0; i< inputData.length();i++){
            charAt = inputData.charAt(i);
            if(Character.isDigit(charAt) == false){
                return true;
            }
        }
        return false;
    }

    private static boolean isBlank(String inputData){
        return inputData.isBlank();
    }
}
