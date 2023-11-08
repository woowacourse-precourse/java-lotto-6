package lotto.view;

import java.util.List;

public class OutputView {
    private final static String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    public static void printBuyLottoCount(int lottoCount){
        System.out.println(lottoCount+BUY_COUNT_MESSAGE);
    }

    public void printLottoNumber(List<Integer> numbers){
        System.out.println(numbers);
    }
    public static void printLottoResultMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
