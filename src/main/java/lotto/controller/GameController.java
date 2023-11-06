package lotto.controller;

import java.util.List;
import lotto.LottoGenerator;
import lotto.Validator.LottoValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

//    while (true) {
//        System.out.println("구입금액을 입력해 주세요.");
//        String stringPurchaseAmount = Console.readLine();
//
//        try {
//            return Integer.parseInt(stringPurchaseAmount);
//        } catch (NumberFormatException e) {
//            System.err.print("[ERROR] 올바른 입력이 아닙니다. ");
//        }
//    }

    public void run() {

        LottoGenerator lottoGenerator = new LottoGenerator();

        int lottoQuantity = purchaseLottoQuantity();
        List<Lotto> lottoTickets = lottoGenerator.createLottoTickets(lottoQuantity);

        LottoBuyer lottoBuyer = new LottoBuyer(lottoTickets);

        OutputView.announceLottoPurchaseQuantity(lottoBuyer.getPurchaseQuantity());
        OutputView.announceMultipleLottoNumbers(lottoBuyer.getLottoTickets());

        List<Integer> winningLottoNumbers = requestWinningLottoNumbers();
        LottoManager lottoManager = new LottoManager(winningLottoNumbers);

        
    }

    private int purchaseLottoQuantity() {
        while (true) {
            try {
                String stringPurchaseAmount = InputView.requestLottoPurchaseAmount();
                int purchaseAmount = Integer.parseInt(stringPurchaseAmount);
                LottoValidator.isValidPurchaseAmount(purchaseAmount);

                return purchaseAmount / 1000;
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 구입금액을 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 구입 금액은 1000원 단위여야 합니다. 구입금액을 다시 입력해주세요.");
            }
        }
    }

    private List<Integer> requestWinningLottoNumbers() {
        while(true) {
            try {
                List<Integer> winningLottoNumbers = InputView.requestWinningLottoNumbers();
                LottoValidator.isValidWinningLottoNumbers(winningLottoNumbers);

                return winningLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 번호의 개수는 6개, 범위는 1~45 사이이며 중복된 숫자가 없어야 합니다. 당첨 번호를 다시 입력해주세요.");
            }
        }
    }


}
