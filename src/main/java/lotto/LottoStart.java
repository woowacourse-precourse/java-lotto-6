package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoStart {

    private static final String HOW_MUCH_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MAKE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MAKE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void run(){

        firstGameProgress();
        secondGameProgress();
        thirdGameProgress();

    }


    public static void firstGameProgress(){
        System.out.print(LottoStart.HOW_MUCH_BUY_MESSAGE);
    }
    public static void firstInputProgress(){
        String inputHowMuchBuy = Console.readLine();
        Integer.parseInt(inputHowMuchBuy);
    }

    private static void secondGameProgress() {
        System.out.print(LottoStart.MAKE_WINNING_NUMBER);
    }

    private static void thirdGameProgress() {
        System.out.print(LottoStart.MAKE_BONUS_NUMBER);
    }


}
