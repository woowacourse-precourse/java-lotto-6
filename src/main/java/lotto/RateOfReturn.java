package lotto;



public class RateOfReturn {

    private static final String PRINT_5ST = "3개 일치 (5,000원) - ";
    private static final String PRINT_4ST = "4개 일치 (50,000원) - ";
    private static final String PRINT_3ST = "5개 일치 (1,500,000원) - " ;
    private static final String PRINT_2ST = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_1ST = "6개 일치 (2,000,000,000원) - ";

    int[] rankCount = new int[5]; //0: 1등, 1: 2등, ...

    Rewords rewords;
    int[][] totalMatch;
    int totalPayment;
    double RoR;

    public RateOfReturn(int[][] totalMatch, int totalPayment){
        this.totalMatch = totalMatch;
        this.totalPayment = totalPayment;
        setRankCount();
    }

    public void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------------");
        System.out.println(PRINT_5ST + rankCount[4] +"개");
        System.out.println(PRINT_4ST + rankCount[3] + "개");
        System.out.println(PRINT_3ST + rankCount[2] + "개");
        System.out.println(PRINT_2ST + rankCount[1] + "개");
        System.out.println(PRINT_1ST + rankCount[0] + "개");
        System.out.println("총 수익률은 "+ RoR +"%입니다.");
    }

    public void setRankCount() {
        for(int i = 0; i<totalMatch.length; i++){
            checkRank(totalMatch[i]);
        }
    }


    private void checkRank(int[] totalMatch) {//[0] 전체 맞은 개수, [1] 보너스 번호 체크
        if (totalMatch[0] == 6 && totalMatch[1] == 0) rankCount[0]++;
        if (totalMatch[0] == 6 && totalMatch[1] == 1) rankCount[1]++;
        if (totalMatch[0] == 5 && totalMatch[1] == 0) rankCount[2]++;
        if (totalMatch[0] == 4 && totalMatch[1] == 0) rankCount[3]++;
        if (totalMatch[0] == 3 && totalMatch[1] == 0) rankCount[4]++;
    }


    public double setROR(){
        int totalReword = setTotalReword();
        double temp = totalReword*100.0 / totalPayment;
        RoR = Math.round(temp * 100) /100.0;
        return RoR;
    }

    public int setTotalReword() {
        int totalReword = 0;
        int i = 0;
        for(Rewords rewords : Rewords.values()){
            totalReword += rewords.calcReword(rankCount[i]);
            i++;
        }
        return totalReword;
    }

}
