package lotto.Controller;

public class Validator {
    final static String NULL_ERROR_MESSAGE = "[ERROR] 입력 값은 널값이 될 수 없습니다.";
    final static String NUMBER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자여야 합니다.";
    final static String AMOUNT_ERROR_MESSAGE = "[ERROR] 입력 값은 널값이 될 수 없습니다.";

    public static int validatePurchaseAmount(String input) {
        if (Validator.validateInputIsNull(input)) {
            System.out.println(NULL_ERROR_MESSAGE);
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }

        if (!Validator.validateInputIsNumeric(input)) {
            System.out.println(NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }

        if (!Validator.validateInputPurchaseAmount(input)) {
            System.out.println(AMOUNT_ERROR_MESSAGE);
            throw new IllegalArgumentException(AMOUNT_ERROR_MESSAGE);
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
        int NumCount = 0;
        for (String num : nums) {
            if (!num.isEmpty()&&validateNumberRange(Integer.parseInt(num))&&validateInputIsNumeric(num)) {
                NumCount++;
            }
        }
        if (NumCount != 6) {
            throw new IllegalArgumentException("[ERROR] 입력값이 잘못됐습니다.");
        }
        return true;
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
