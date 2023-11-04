package lotto.view;

public class OutputView {

    private static final String INPUT_AMOUNT_OF_MONEY = "구입금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String TOTAL_PRIZE = "당첨 통계\n---";


    public final void print_Input_Amount_Of_Money () {
        System.out.println(INPUT_AMOUNT_OF_MONEY);
    }

    public final void print_How_Many_Buy () {
        System.out.println(HOW_MANY_BUY);
    }

    public final void print_Input_Lotto_Number () {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

    public final void print_Input_Bonus_Number () {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public final void print_TotalPrize() {
        System.out.println(TOTAL_PRIZE);
    }


}
