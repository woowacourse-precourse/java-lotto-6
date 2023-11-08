package lotto;

public class RateOfReturn {

    private static final String PRINT_5ST = "3개 일치 (5,000원) - ";
    private static final String PRINT_4ST = "4개 일치 (50,000원) - ";
    private static final String PRINT_3ST = "5개 일치 (1,500,000원) - " ;
    private static final String PRINT_2ST = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_1ST = "6개 일치 (2,000,000,000원) - ";


    private static final int REWORD_1ST = 2000000000;
    private static final int REWORD_2ST = 30000000;
    private static final int REWORD_3ST = 1500000;
    private static final int REWORD_4ST = 50000;
    private static final int REWORD_5ST = 5000;
    private static final int RANK_SIZE = 5;

    int[] Rewords = {REWORD_1ST,REWORD_2ST,REWORD_3ST,REWORD_4ST,REWORD_5ST};

    int[][] totalMatch;
    int totalReword = 0;
    static int[] countRank = new int[RANK_SIZE]; // 0: 1등 , 1: 2등, 2: 3등, ... , 4: 5등

    double ROR = 0.0;

    public RateOfReturn(int[][] totalMatch, int totalPayment){
        this.totalMatch = totalMatch;
        setRankCount(totalMatch);
        setROR(totalPayment);
        printResult();
    }

    private void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------------");
        System.out.println(PRINT_5ST + countRank[4] +"개");
        System.out.println(PRINT_4ST + countRank[3] + "개");
        System.out.println(PRINT_3ST + countRank[2] + "개");
        System.out.println(PRINT_2ST + countRank[1] + "개");
        System.out.println(PRINT_1ST + countRank[0] + "개");
        System.out.println("총 수익률은 "+ ROR +"%입니다.");

    }

    private void setRankCount(int[][] totalMatch) {
        for(int i = 0; i<totalMatch.length; i++){
            int rank = checkRank(totalMatch[i]);
            setRank(rank);
        }
    }

    private void setRank(int rank) {
        if (rank > 0) countRank[rank-1]++;
    }

    private int checkRank(int[] totalMatch) {//[0] 전체 맞은 개수, [1] 보너스 번호 체크
        if (totalMatch[0] == 6 && totalMatch[1] == 0) return 1;
        if (totalMatch[0] == 6 && totalMatch[1] == 1) return 2;
        if (totalMatch[0] == 5 && totalMatch[1] == 0) return 3;
        if (totalMatch[0] == 4 && totalMatch[1] == 0) return 4;
        if (totalMatch[0] == 3 && totalMatch[1] == 0) return 5;
        return 0;

    }


    public void setROR(int payment){
        setTotalReword();
        double temp = totalReword*100.0 / payment;
        ROR = Math.round( temp * 100) /100.0;
    }

    private void setTotalReword() {
        for(int i = 0; i <RANK_SIZE; i++){
            totalReword += countRank[i] * Rewords[i];
        }
    }

}
