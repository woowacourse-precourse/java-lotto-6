package lotto.Controller;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        if (Validator.validateInputIsNull(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 널값이 될 수 없습니다.");
        }

        if (!Validator.validateInputIsNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }

        if (!Validator.validateInputPurchaseAmount(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 양수거나 1,000원 단위여야 합니다.");
        }

        return Integer.parseInt(input);
    }

    public static boolean validateInputPurchaseAmount(String input){
        return Integer.parseInt(input) % 1000 == 0 && Integer.parseInt(input) > 0;
    }

    public static boolean validateInputIsNumeric(String input){
        try{
            int validate = Integer.parseInt(input);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean validateInputIsNull(String input){
        return input==null;
    }
    public static boolean validateNumberRange(int num){
        return 1 <= num && num <= 45;
    }
    public static boolean validateInputWinningNumber(String input){
        String[] nums = input.split(",");
        int nonEmptyNumCount = 0;
        for (String num : nums) {
            if (!num.isEmpty()) {
                nonEmptyNumCount++;
            }
        }
        return nonEmptyNumCount == 6;
    }

    public static int validateBonusNumber(String input){
        if (Validator.validateInputIsNull(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 널값이 될 수 없습니다.");
        }

        if (!Validator.validateInputIsNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }

        if (!Validator.validateNumberRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }

    public static boolean validateInputBonusNumber(int num){
        return validateNumberRange(num);
    }
}
