package View;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

enum ERROR_MESSAGE {
    WRONG_FORMAT("[ERROR] 1~45의 자연수를 입력해야합니다. 다시 입력하세요");

    private ERROR_MESSAGE() {

    }

    private ERROR_MESSAGE(String s) {
    }
}

public class batInput {
    private static int price;


    public static int getPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            price = parseInt(Console.readLine());
            checkDigits();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            return getPrice();
        }
        return price;
    }

    private static int checkDigits() {
        try {
            if (price<=0 || price % 1000 != 0){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_FORMAT);
            return getPrice();
        }
        return 0;
    }

}
