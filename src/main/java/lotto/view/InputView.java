package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Positive;

public class InputView {

    private static final String REQUEST_BUY_MONEY = "구입 금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_NOT_THOUSAND_UNIT = "입력값은 1000 단위의 숫자여야 합니다.";


    private static final int LOTTO_PRICE = 1000;
    //구입 금액을 입력해 주세요
    public static int getLottoCount(){
        while (true){
            try{
                Positive positive = new Positive(requestInput(REQUEST_BUY_MONEY));
                Positive lottoCount = positive.divide(new Positive(LOTTO_PRICE));
                return lottoCount.getNumber();
            }catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }

    }
//    public static void require

    public static void messageBuyMoney(){
        System.out.println(REQUEST_BUY_MONEY);
    }
    public static void  messageAskLottoNumber(){
        System.out.println(REQUEST_LOTTO_NUMBER);
    }
    public static void messageAskBonusNumber(){
        System.out.println(REQUEST_BONUS_NUMBER);
    }


    private static String requestInput(String message) {
        System.out.println(message);
        String input = readLine();
        validateThousandUnit(input);
        return input;
    }

    private static void validateThousandUnit(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0 || value % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_NOT_THOUSAND_UNIT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_THOUSAND_UNIT);
        }
    }



}
