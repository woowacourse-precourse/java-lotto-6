package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.PrintError;

public class InputGuide {
    private static final String LOTTO_PRICE_GUIDE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUM_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUM_GUIDE = "보너스 번호를 입력해 주세요.";



    public static int inputPrice(){
        System.out.println(LOTTO_PRICE_GUIDE);

        String inputPrice = Console.readLine();
        inputPriceValidateion(inputPrice);

        int totalPrice = Integer.parseInt(inputPrice);
        priceValidation(totalPrice);

        return totalPrice;
    }

    private static void priceValidation(int totalPrice) {
        if (totalPrice % 1000 != 0){
            System.out.println(PrintError.priceError());
            throw new IllegalArgumentException();
        }
    }

    private static void inputPriceValidateion(String inputprice) {
        nullValidate(inputprice); //아무것도 입력하지 않음
        decimalValidate(inputprice); //올바르지 않은 정수 검사
    }

    private static void decimalValidate(String inputprice) {//유효한 정수 확인
        if (!inputprice.matches("\\d+")) {
            System.out.println(PrintError.decimalException());
            throw new IllegalArgumentException();
        }
    }

    private static void nullValidate(String inputprice) {
        if(inputprice.isEmpty()){
            System.out.println(PrintError.nullException());
            throw new IllegalArgumentException();
        }

    }

    public static int inputBonusNum(){
        System.out.println(LOTTO_BONUS_NUM_GUIDE);
        String bonusInput = Console.readLine();
        inputPriceValidateion(bonusInput);
        bonusValidation(Integer.parseInt(bonusInput));

        return Integer.parseInt(bonusInput);
    }

    private static void bonusValidation(int bonus) {
        if(bonus > 45 && bonus < 1){
            System.out.println(PrintError.rangeError());
            throw new IllegalArgumentException();
        }
    }

    public static String inputWinningNum(){
        System.out.println(LOTTO_WINNING_NUM_GUIDE);

        return Console.readLine();
    }
}
