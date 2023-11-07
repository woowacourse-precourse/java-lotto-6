package lotto.view;

import lotto.model.WinningInfo;

public class OutputView {
    
    private final static String GETSTATISTICS = "\n당첨 통계\n---";
    private final static String FIFTHRANK = "3개 일치 (5,000원) - ";
    private final static String FOURTHRANK = "4개 일치 (50,000원) - ";
    private final static String THIRDRANK = "5개 일치 (1,500,000원) - " ;
    private final static String SECONDRANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - " ;
    private final static String FIRSTRANK = "6개 일치 (2,000,000,000원) - ";

    public void getEndLotto(WinningInfo winninginfo, float buycost){
        long totalamount = winninginfo.getTotalAmount();
        System.out.println(GETSTATISTICS);
        System.out.println(FIFTHRANK + winninginfo.getFifthRank() +"개");
        System.out.println(FOURTHRANK + winninginfo.getfourthrank()+"개");
        System.out.println(THIRDRANK + winninginfo.getthirdrank()+"개");
        System.out.println(SECONDRANK + winninginfo.getsecondrank()+"개");
        System.out.println(FIRSTRANK + winninginfo.getfirstrank()+"개");
        System.out.println("총 수익률은 " + (totalamount/buycost)*100 +"%입니다.");
        System.out.println("---");
    }
}
