package lotto;

import lotto.Rewords;

public class RateOfReturn {

    private static final String PRINT_5ST = "3개 일치 (5,000원) - ";
    private static final String PRINT_4ST = "4개 일치 (50,000원) - ";
    private static final String PRINT_3ST = "5개 일치 (1,500,000원) - " ;
    private static final String PRINT_2ST = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_1ST = "6개 일치 (2,000,000,000원) - ";

    private static final int RANK_SIZE = 5;

    int[][] totalMatch;

    public RateOfReturn(int[][] totalMatch, int totalPayment){
        this.totalMatch = totalMatch;
        setRankCount(totalMatch);
        double RoR = setROR(totalPayment);
        printResult(RoR);
    }

    public void printResult(double RoR) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------------");
        System.out.println(PRINT_5ST + Rewords.REWORDS_5ST.getCnt() +"개");
        System.out.println(PRINT_4ST + Rewords.REWORDS_4ST.getCnt() + "개");
        System.out.println(PRINT_3ST + Rewords.REWORDS_3ST.getCnt() + "개");
        System.out.println(PRINT_2ST + Rewords.REWORDS_2ST.getCnt() + "개");
        System.out.println(PRINT_1ST + Rewords.REWORDS_1ST.getCnt() + "개");
        System.out.println("총 수익률은 "+ RoR +"%입니다.");

    }

    private void setRankCount(int[][] totalMatch) {
        for(int i = 0; i<totalMatch.length; i++){
            checkRank(totalMatch[i]);
        }
    }


    private void checkRank(int[] totalMatch) {//[0] 전체 맞은 개수, [1] 보너스 번호 체크
        if (totalMatch[0] == 6 && totalMatch[1] == 0) Rewords.REWORDS_1ST.addCnt();
        if (totalMatch[0] == 6 && totalMatch[1] == 1) Rewords.REWORDS_2ST.addCnt();
        if (totalMatch[0] == 5 && totalMatch[1] == 0) Rewords.REWORDS_3ST.addCnt();
        if (totalMatch[0] == 4 && totalMatch[1] == 0) Rewords.REWORDS_4ST.addCnt();
        if (totalMatch[0] == 3 && totalMatch[1] == 0) Rewords.REWORDS_5ST.addCnt();
    }


    public double setROR(int payment){
        int totalReword = setTotalReword();
        double temp = totalReword*100.0 / payment;
        return Math.round(temp * 100) /100.0;
    }

    public int setTotalReword() {
        int totalReword = 0;
        for(Rewords rewords : Rewords.values()){
            totalReword += rewords.calcReword();
        }
        return totalReword;
    }

}
