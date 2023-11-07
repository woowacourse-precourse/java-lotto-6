package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static int purchaseAmount;
    public static int bonusNumber;
    public static List<Lotto> lottos;
    public static List<Integer> winNumbers;
    public static Map<Rank, Integer> lottoResult;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        runPurchaseAmountPart();

        runCalculateIssuePart();

        runWinNumbersPart();

        runBonusNumberPart();

        runLottoResultPart();

        runReturnRatePart();
    }

    public static void runPurchaseAmountPart() {
        final String purchaseAmountMessage = "\n구입금액을 입력해 주세요.";
        Output.message(purchaseAmountMessage);
        try {
            purchaseAmount = Input.purchaseAmount();
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.message(illegalArgumentException.getMessage());
            runPurchaseAmountPart();
        }
    }

    public static void runCalculateIssuePart() {
        int issueCount = Lotto.calculateIssueCount(purchaseAmount);
        lottos = Lotto.issueLotto(issueCount);
        Output.issueLotto(issueCount, lottos);
    }

    public static void runWinNumbersPart() {
        final String winNumbersMessage = "\n당첨 번호를 입력해 주세요.";
        Output.message(winNumbersMessage);
        try {
            winNumbers = Input.winNumbers();
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.message(illegalArgumentException.getMessage());
            runWinNumbersPart();
        }
    }

    public static void runBonusNumberPart() {
        final String bonusNumberMessage = "\n보너스 번호를 입력해 주세요.";
        Output.message(bonusNumberMessage);
        try {
            bonusNumber = Input.bonusNumber();
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.message(illegalArgumentException.getMessage());
            runBonusNumberPart();
        }
    }

    public static void runLottoResultPart() {
        lottoResult = Lotto.isWin(lottos, winNumbers, bonusNumber);
        Output.winStatistics(lottoResult);
    }

    public static void runReturnRatePart() {
        double returnRate = Lotto.calculateReturnRate(lottoResult, purchaseAmount);
        Output.returnRate(returnRate);
    }
}
