package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoManager;
import lotto.generator.LottoGenerator;
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
    LottoManager lottoManager = new LottoManager();

    public void run() {

        int lottoQuantity = purchaseLottoQuantity();
        List<Lotto> lottoTickets = lottoManager.createLottoTickets(lottoQuantity);

        LottoBuyer lottoBuyer = new LottoBuyer(lottoTickets);

        OutputView.announceLottoPurchaseQuantity(lottoBuyer.getPurchaseQuantity());
        OutputView.announceMultipleLottoNumbers(lottoBuyer.getLottoTickets());

        List<Integer> winningLottoNumbers = InputView.requestWinningLottoNumbers();
        lottoManager.isValidWinningLottoNumbers(winningLottoNumbers);

    }



    private int purchaseLottoQuantity() {
        while (true) {
            try {
                String stringPurchaseAmount = InputView.requestLottoPurchaseAmount();
                int purchaseAmount = Integer.parseInt(stringPurchaseAmount);
                lottoManager.isValidPurchaseAmount(purchaseAmount);

                return purchaseAmount / 1000;
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 구입금액을 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 구입 금액은 1000원 단위여야 합니다. 구입금액을 다시 입력해주세요.");
            }
        }
    }


}
