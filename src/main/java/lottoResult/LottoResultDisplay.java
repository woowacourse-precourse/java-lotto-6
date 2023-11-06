package lottoResult;

import static constant.GeneralMessage.WINNING_STATISTICS_NOTICE_MESSAGE;

import java.util.List;

public class LottoResultDisplay {
    LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
    public int sixSuccess;
    public int fiveSuccess;
    public int fiveAndBonusSuccess;
    public int fourSuccess;
    public int threeSuccess;

    public LottoResultDisplay() {
        System.out.println(WINNING_STATISTICS_NOTICE_MESSAGE);
    }

    public void getLottoSuccessCount(List<List<Integer>> userLottoNumbers, List<Integer> winningNumberList,
                                     int bonusNumber) {
        lottoResultCalculator.Calculator(userLottoNumbers, winningNumberList, bonusNumber);
        sixSuccess = lottoResultCalculator.sixSuccess;
        fiveSuccess = lottoResultCalculator.fiveSuccess;
        fiveAndBonusSuccess = lottoResultCalculator.fiveAndBonusSuccess;
        fourSuccess = lottoResultCalculator.fourSuccess;
        threeSuccess = lottoResultCalculator.threeSuccess;
    }

    public void outputLottoResult() {
        System.out.println("3개 일치 (5,000원) - " + threeSuccess + "개");
        System.out.println("4개 일치 (50,000원) - " + fourSuccess + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveSuccess + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusSuccess + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixSuccess + "개");
    }
}