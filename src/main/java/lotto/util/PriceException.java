package lotto.util;

public class PriceException {
    public static void validPrice(int money) {

    }

    private static void checkChar(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] : 옳바른 숫자를 입력해주세요");
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
}
