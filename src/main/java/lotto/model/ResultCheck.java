package lotto.model;
import lotto.view.View;
import java.text.DecimalFormat;

public class ResultCheck {
    static int[][] lottos;
    static int[] winningNumber;
    static int[] matchcount = new int[LottoSetUp.cols];
    static public int threeMatch = 0;
    static public int fourMatch = 0;
    static public int fiveMatch = 0;
    static public int fiveWithBonusMatch = 0;
    static public int sixMatch = 0;

    static String resultRevenue;
    static int totalBenefit = 0;

    public static void setUpJudgeResult() {
        lottos = LottoSetUp.getLottos();
        winningNumber = LottoSetUp.getWinningNumbers();
        for(int i = 0; i < LottoSetUp.cols; i++) {
            judgeResult(i);
        }
    }

    public static void judgeResult(int i) {
        for (int j = 0; j < winningNumber.length; j++) {
            for (int k = 0; k < winningNumber.length; k++) {
                calculateResult(k,i,j);
            }
        }
    }

    public static void calculateResult(int k, int i, int j) {
        if (lottos[i][j] == winningNumber[k]) {
            matchcount[i]++;
        }
    }

    public static void SetUpBonusChecker() {
        for(int i = 0; i < matchcount.length; i++) {
            if(matchcount[i] == 5) {
                bonusChecker(i);
            }
        }
    }

    public static void bonusChecker(int i) {
        int bonusNumber = View.getBonusNumber();
        for(int j = 0; j < winningNumber.length; j++) {
            if(lottos[i][j] == bonusNumber) {
                matchcount[i] += 2;
            }
        }
    }

    public static void DeclarationLottoMatch() {
        for (int i = 0; i < matchcount.length; i++) {
            if(matchcount[i] == 3) {
                threeMatch ++;
            }
            if(matchcount[i] == 4) {
                fourMatch ++;
            }
            if(matchcount[i] == 5) {
                fiveMatch ++;
            }
            if(matchcount[i] == 7) {
                fiveWithBonusMatch ++;
            }
            if(matchcount[i] == 6) {
                sixMatch ++;
            }
        }
    }

    public static void benefitCheck() {
        totalBenefit = (threeMatch * 5000 + fourMatch * 50000 + fiveMatch * 1500000 + fiveWithBonusMatch * 30000000 + sixMatch * 2000000000);
        double totalRevenue = (double) totalBenefit * 100 / View.getTotalCost();
        DecimalFormat df = new DecimalFormat("#.##");
        resultRevenue = df.format(totalRevenue);
        System.out.println(totalBenefit);
    }

    public static String getResultRevenue() {
        return resultRevenue;
    }

    public static int[] getWinningNumber() {
        return winningNumber;
    }
}
