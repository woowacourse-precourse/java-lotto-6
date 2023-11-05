package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
        Output.message(purchaseAmountMessage);

        int purchaseAmount = Input.purchaseAmount();
        int issueCount = Lotto.calculateIssueCount(purchaseAmount);
        List<Lotto> lottos = Lotto.issueLotto(issueCount);
        Output.issueLotto(issueCount, lottos);

        final String winNumbersMessage = "\n당첨 번호를 입력해 주세요.";
        Output.message(winNumbersMessage);
        List<Integer> winNumbers = Input.winNumbers();

        final String bonusNumberMessage = "\n보너스 번호를 입력해 주세요.";
        Output.message(bonusNumberMessage);
        int bonusNumber = Input.bonusNumber();

        Map<Rank, Integer> lottoResult = Lotto.isWin(lottos, winNumbers, bonusNumber);
        Output.winStatistics(lottoResult);

        double returnRate = Lotto.calculateReturnRate(lottoResult, purchaseAmount);
        Output.returnRate(returnRate);
    }
}
