package lotto.util;

public class InputException {
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
}
