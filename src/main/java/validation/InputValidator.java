package validation;

public class InputValidator {

    public static void validInputMoney(String lottoMoney) {
        if(isDigit(lottoMoney)) {
            throw new IllegalArgumentException("구입 금액은 숫자만 입력할 수 있습니다.");
        }
        if(isDivisible(lottoMoney) || isCorrectRange(lottoMoney)) {
            throw new IllegalArgumentException("최소 금액은 1000원으로, 1000원 단위의 금액이어야 합니다.");
        }
    }


    private static boolean isDigit(String lottoMoney) {
        String pattern = "^[0-9]*$";
        return !lottoMoney.matches(pattern);
    }

    private static boolean isDivisible(String lottoMoney) {
        return !(Integer.parseInt(lottoMoney) % 1000 > 0); // lottoMoney를 1000원으로 나눈 나머지가 0 이상이면 false 반환
    }

    private static boolean isCorrectRange(String lottoMoney) {
        return !(Integer.parseInt(lottoMoney) < 1000); // lottoMoney가 1000 미만이면 false 반환
    }

}
