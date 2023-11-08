package View;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

enum ERROR_MESSAGE {
    WRONG_PRICE("[ERROR] 1000자리 단위의 자연수를 입력해야합니다. 다시 입력하세요"),
    WRONG_FORMAT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private final String label;
    ERROR_MESSAGE(String label){
        this.label =label;
    }
    public String label(){
        return label;
    }
}

public class BatInput {
    private static int price;


    public static int getPrice() {
        try {
            System.out.println(REQUEST_MESSAGE.REQUEST_PRICE.label());
            price = parseInt(Console.readLine());
            checkDigits();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE.WRONG_PRICE.label());
            getPrice();
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
            System.out.println(ERROR_MESSAGE.WRONG_PRICE.label());
            getPrice();
        }
        return 0;
    }

}
