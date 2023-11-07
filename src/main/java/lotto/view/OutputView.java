package lotto.view;

import lotto.model.WinningInfo;

public class OutputView {
    
    static WinningInfo winninginfo = new WinningInfo();

    private final static String GETSTATISTICS = "당첨 통계\n---\n";
    private final static String FIFTHRANK = "3개 일치 (5,000원) - "+ winninginfo.getFifthRank();
    private final static String FOURTHRANK = "4개 일치 (50,000원) - " + winninginfo.getfourthrank();
    private final static String THIRDRANK = "5개 일치 (1,500,000원) - " + winninginfo.getthirdrank();
    private final static String SECONDRANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winninginfo.getsecondrank();
    private final static String FIRSTRANK = "6개 일치 (2,000,000,000원) - " + winninginfo.getfirstrank();

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
