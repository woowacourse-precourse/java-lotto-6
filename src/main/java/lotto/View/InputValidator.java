package lotto.View;

public class InputValidator {
    public static void validateInsertInteger(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException("[ERROR] 입력이 없습니다");
        }

        if(isNotNumber(inputValue)){
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
        };

    }

    public static void validateInsertString(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException("[ERROR] 입력이 없습니다.");
        }
    }

    private static boolean isNotNumber(String inputData){
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isBlank(String inputData){
        return inputData.isBlank();
    }
}
