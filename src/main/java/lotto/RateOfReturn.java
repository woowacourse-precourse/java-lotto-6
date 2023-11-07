package lotto;

public class RateOfReturn {

    private static final int REWORD_1ST = 2000000000;
    private static final int REWORD_2ST = 30000000;
    private static final int REWORD_3ST = 1500000;
    private static final int REWORD_4ST = 50000;
    private static final int REWORD_5ST = 5000;
    private static final int RANK_SIZE = 5;

    int[] Rewords = {REWORD_1ST,REWORD_2ST,REWORD_3ST,REWORD_4ST,REWORD_5ST};

    int[][] totalMatch;
    int totalReword = 0;
    int[] countRank = new int[RANK_SIZE]; // 0: 1등 , 1: 2등, 2: 3등, ... , 4: 5등

    double ROR = 0.0;

    public RateOfReturn(int[][] totalMatch, int totalPayment){
        this.totalMatch = totalMatch;
        setRankCount(totalMatch);
        setROR(totalPayment);
        printResult();
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("----------------");
        System.out.println("3개 일치 (" + REWORD_5ST +") - " + countRank[4] + "개");
        System.out.println("4개 일치 (" + REWORD_4ST +") - " + countRank[3] + "개");
        System.out.println("5개 일치 (" + REWORD_3ST +") - " + countRank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + REWORD_2ST +") - " + countRank[1] + "개");
        System.out.println("6개 일치 (" + REWORD_1ST +") - " + countRank[0] + "개");
        System.out.println("총 수익률은 62.5%d 입니다.");

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

    private int checkRank(int[] totalMatch) {
        if (totalMatch[0] == 6) return 1;
        if (totalMatch[0] == 5 && totalMatch[1] == 1) return 2;
        if (totalMatch[0] == 5) return 3;
        if (totalMatch[0] == 4) return 4;
        if (totalMatch[0] == 3) return 5;
        return 0;

    }


    public void setROR(int payment){
        setTotalReword();
        ROR = (double) Math.round((totalReword / payment) * 100) /100;
    }

    private void setTotalReword() {
        for(int i = 0; i <RANK_SIZE; i++){
            totalReword += countRank[i] * Rewords[i];
        }
    }

}
