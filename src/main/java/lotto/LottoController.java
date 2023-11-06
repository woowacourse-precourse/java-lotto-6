package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    static final String INPUT_PROMPT_AMOUNT_TO_PAY = "구입금액을 입력해 주세요.";
    static final int LOTTO_PRICE = 1000;
    private int lottoTicketCount;
    private List<Lotto> issuedLottos;

    public LottoController() {
        issuedLottos = new ArrayList<>();
    }

    private void inputAmountToPay() {
        int totalAmountToPay;

        System.out.println(INPUT_PROMPT_AMOUNT_TO_PAY);
        totalAmountToPay = Integer.parseInt(Console.readLine());
        this.lottoTicketCount = calculateLottoTicketCount(totalAmountToPay);
    }

    private int calculateLottoTicketCount(int totalAmountToPay) {
        return totalAmountToPay / LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void createLotto() {
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);

            this.issuedLottos.add(lotto);
        }
    }

    private void displayIssuedLottos() {
        for(Lotto lotto: this.issuedLottos) {
            lotto.displayLottoNumbers();
        }
    }


}
