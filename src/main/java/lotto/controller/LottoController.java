package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.utils.Utils;
import lotto.validation.Validator;
import lotto.view.NumberSettingView;
import lotto.view.PurchaseView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.SystemData.MAX_IN_LOTTO_NUMBER;
import static lotto.constant.SystemData.MIN_IN_LOTTO_NUMBER;

public class LottoController {
    private Buyer buyer;

    public void run() {
        initBuyer();
        showPurchaseStatus();
    }

    private void initBuyer() {
        int purchaseAmount = getPurchaseAmount();
        ArrayList<Lotto> lottoTickets = purchaseLottoTickets(purchaseAmount);
        buyer = new Buyer(purchaseAmount, lottoTickets);
    }

    public void showPurchaseStatus() {
        printPurchasedTicketCount();
        printLottoTicketNumbers();
    }

    /* 구입금액 입력 */
    private int getPurchaseAmount() {
        PurchaseView.printInputPurchaseAmount();

        try {
            int purchaseAmount = Utils.stringToInt(Console.readLine());
            Validator.checkInputPriceValidation(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    /* 금액에 맞추어 로또 여러 개 발행 */
    private ArrayList<Lotto> purchaseLottoTickets(int purchaseAmount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / 1000; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            lottoTickets.add(new Lotto(lottoNumbers));
        }

        return lottoTickets;
    }

    /* 로또 6자리 랜덤 숫자 생성 */
    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(MIN_IN_LOTTO_NUMBER, MAX_IN_LOTTO_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    /* 로또 구매 개수 출력 */
    public void printPurchasedTicketCount() {
        int number = buyer.getLottoTicketCount();
        PurchaseView.printPurchasedTicketCount(number);
    }

    /* 로또 6자리 숫자 출력 */
    public void printLottoTicketNumbers() {
        for(List<Integer> numbers : buyer.getLottoTicketNumbers())
            System.out.println(numbers);
    }

    public void getInputWinningNumbers() {
        //TODO: 당첨번호 입력
        NumberSettingView.printInputWinningNumbers();
        int[] winningNumbers = Utils.stringToIntArray(Console.readLine());
    }

    public void getInputBonusNumber() {
        //TODO: 보너스번호 입력
    }

    public void showWinningResult() {
        //TODO: 당첨 통계 출력
    }
}
