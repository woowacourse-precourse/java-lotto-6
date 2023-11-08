package lotto;

public class GameController {
    static boolean reInput = true;

    static void GameStart() {
        System.out.println("구입금액을 입력해 주세요.");
        LottoPurchaseInput.inputLottoPurchaseAmount();

        OutputView.printPurchaseCount(LottoPurchaseInput.lottoPurchaseAmount);
        LottoTicketGenerator.generateRandomLottoNumbers(OutputView.lottoPurchaseCount);

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        while (reInput) {
            reInput = false;
            LottoWinnerInput.inputWinningNumbers();
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        do {
            LottoBonusInput.getBonusNumber();
        } while (LottoBonusInput.validateBonusNum());

        LottoBonusInput.validateBonusNum();
        System.out.println();
        CompareWinnerNum.compareNumbers();
        OutputView.printLottoGameStatics();
        OutputView.printProfitRate(Service.calculateTotalPrizeMoney());
        Service.printProfitability();
    }
}
