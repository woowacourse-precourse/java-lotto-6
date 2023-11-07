package lotto.view;

public class OutputView {
    
    private final static String GETSTATISTICS = "당첨 통계\n---";
    private final static String FIFTHRANK = "3개 일치 (5,000원) - ";
    private final static String FOURTHRANK = "4개 일치 (50,000원) - ";
    private final static String THIRDRANK = "5개 일치 (1,500,000원) - ";
    private final static String SECONDRANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String FIRSTRANK = "6개 일치 (2,000,000,000원) - ";

    public void getEndLotto(){
        System.out.println(GETSTATISTICS);
        System.out.println(FIFTHRANK);
        System.out.println(FOURTHRANK);
        System.out.println(THIRDRANK);
        System.out.println(SECONDRANK);
        System.out.println(FIRSTRANK);
        System.out.println("총 수익률은" + " " +"입니다.");
    }
}
