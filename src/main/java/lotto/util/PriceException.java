package lotto.util;

public class PriceException {
    public static void validPrice(int money) {
        checkPositiveNumber(money);
        checkMultipleOfThousand(money);
    }

    public static void checkValidNumber (String input) {
        try{
            checkEmpty(input);
            invalidSpace(input);
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] : 옳바른 숫자를 입력해주세요.");
        }
    }

    private static void checkMultipleOfThousand (int number){
        if(number % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] : 구입 가격은 1000원 단위입니다.");
        }
    }

    private static void checkPositiveNumber (int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] : 구입 가격은 양수여야 합니다.");
        }
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 빈값은 입력할 수 없습니다.");
        }
    }

    private static void invalidSpace(String input) {
        if (input.contains(" ")){
            throw new IllegalArgumentException("[ERROR] : 입력값에 빈칸은 있으면 안됩니다.");
        }
    }

}
