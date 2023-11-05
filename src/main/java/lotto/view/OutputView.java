package lotto.view;

public class OutputView {
    private static final String LOTTO_NUM_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void lottoNum(int lottoNum){
        System.out.printf(LOTTO_NUM_MESSAGE, lottoNum);
    }
}
