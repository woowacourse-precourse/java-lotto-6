package lotto.validator;

public class WinningNumberValidator {
    public static boolean validate(String winningNum) {
        String[] numbers = winningNum.split(",");
        if(isValidFormat(numbers));
        if(isNumbers(numbers));
        if(isValidNumbers(numbers));
        return true;
    }

    private static boolean isValidFormat(String[] numbers) {
        if(numbers.length!=6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 \"(숫자),(숫자),(숫자),(숫자),(숫자),(숫자)\" 꼴의 입력이어야 합니다.");
        }
        return true;
    }
    private static boolean isNumbers(String[] numbers) {
        try{
            for(String num : numbers) {
                Integer.parseInt(num);
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 숫자가 아닌 입력이 있습니다.");
        }
        return true;
    }
    private static boolean isValidNumbers(String[] numbers) {
        for(String num : numbers) {
            if(Integer.parseInt(num)<0 || 45<Integer.parseInt(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return true;
    }
}
