package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputGuide {
    private static final String LOTTO_PRICE_GUIDE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUM_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUM_GUIDE = "보너스 번호를 입력해 주세요.";



    public int inputPrice(){
        System.out.println(LOTTO_PRICE_GUIDE);

        return Integer.parseInt(Console.readLine());
    }

    public int inputBonusNum(){
        System.out.println(LOTTO_BONUS_NUM_GUIDE);

        return Integer.parseInt(Console.readLine());
    }

    public String inputWinningNum(){
        System.out.println(LOTTO_WINNING_NUM_GUIDE);

        return Console.readLine();
    }
}
