package lotto;

public class Revenue {
    public void revenuerate(int buynumber,int sum){
        int Expenditure = buynumber;
        int totalWin = sum;

        // 수익률 계산
        double revenuerate = ((double) (totalWin  - Expenditure) / Expenditure) * 100;
        if (revenuerate<0){
            revenuerate= 100+revenuerate;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenuerate);
    }

}
