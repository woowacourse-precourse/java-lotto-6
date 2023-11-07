package lotto.view;

public class OutputViewResult {
    private static final String WIN_STATICS_MESSAGE = "당첨 통계";
    private static final String TOTAL_RATE_IS_MESSAGE = "총 수익률은 ";
    private static final String TOTAL_RATE_IS_MESSAGE_FINISH = "입니다.";
    private static final String SEPARATE = "---";

    public static void printResultStart(){
        System.out.println(WIN_STATICS_MESSAGE);
        System.out.println(SEPARATE);
    }

    public static void printResultLotto(){

    }

    public static void printResultRate(Double rate) {
        System.out.println(TOTAL_RATE_IS_MESSAGE + rate + TOTAL_RATE_IS_MESSAGE_FINISH);
    }
}
