package lotto.controller;

import java.util.List;
import lotto.Validator.LottoValidator;
import lotto.domain.LottoManager;
import lotto.domain.LottoBuyer;

import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void run() {

        LottoBuyer lottoBuyer = purchaseLottoTickets();

        OutputView.announceLottoPurchaseQuantity(lottoBuyer.getPurchaseQuantity());
        OutputView.announceMultipleLottoNumbers(lottoBuyer.getLottoTickets());

        List<Integer> winningLottoNumbers = requestWinningLottoNumbers();
        int bonusLottoNumber = requestBonusLottoNumber(winningLottoNumbers);
        LottoManager lottoManager = new LottoManager(winningLottoNumbers, bonusLottoNumber);

        lottoManager.countMatchingCounts(lottoBuyer, lottoManager);
    }

    private LottoBuyer purchaseLottoTickets() {
        while (true) {
            try {
                int purchaseAmount = InputView.requestLottoPurchaseAmount();
                return new LottoBuyer(purchaseAmount);
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

    private int requestBonusLottoNumber(List<Integer> winningLottoNumbers) {
        while(true) {
            try {
                int bonusLottoNumber = InputView.requestBonusLottoNumber();
                LottoValidator.validateDuplicateWinningAndBonusNumbers(winningLottoNumbers, bonusLottoNumber);
                return bonusLottoNumber;
            } catch (IllegalArgumentException e) {
                System.err.println("[ERROR] 번호의 개수는 6개, 범위는 1~45 사이이며 중복된 숫자가 없어야 합니다. 당첨 번호를 다시 입력해주세요.");
            }
        }
    }




}
