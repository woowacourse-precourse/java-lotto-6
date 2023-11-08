package lotto;

import lotto.domain.Prize;
import lotto.service.LottoService;
import lotto.util.UserInputUtil;
import lotto.view.DisplayView;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        UserInputUtil userInputUtil = new UserInputUtil();
        LottoService lottoService = new LottoService();

        // 구입 금액 요청
        DisplayView.displayRequestPurchaseAmount();
        int purchaseAmount = userInputUtil.readPurchaseAmount();

        // 로또 발행 및 표시
        lottoService.generateLottoTickets(purchaseAmount);
        DisplayView.displayPurchasedLottoCount(lottoService.calculateTicketAmount(purchaseAmount));
        DisplayView.displayTickets(lottoService.getLottoTickets());

        // 당첨 번호 및 보너스 번호 입력 요청
        DisplayView.displayRequestWinningNumbers();
        List<Integer> winningNumbers = userInputUtil.readWinningNumbers();
        DisplayView.displayRequestBonusNumber();
        int bonusNumber = userInputUtil.readBonusNumber(winningNumbers);

        // 결과 계산 및 표시
        Map<Prize, Integer> prizeResults = lottoService.calculateResults(winningNumbers, bonusNumber);
        DisplayView.displayResults(prizeResults);

        // 수익률 계산 및 표시
        int totalEarnings = lottoService.calculateTotalEarnings(prizeResults);
        double yield = lottoService.calculateYield(purchaseAmount, totalEarnings);
        DisplayView.displayYield(yield);
    }
}

