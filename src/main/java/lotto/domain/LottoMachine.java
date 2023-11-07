package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final int PURCHASE_UNIT = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    private List<Lotto> lottos;

    public LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int readAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        String purchaseAmountText = readLine();
        int purchaseAmount = Integer.parseInt(purchaseAmountText);
        return purchaseAmount;
    }

    public int amountToIssueCount(int purchaseAmount) {
        int issueCount = purchaseAmount / PURCHASE_UNIT;
        return issueCount;
    }

    public List<Lotto> generate(int issueCount) {
        for (int i = 0; i < issueCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    START_NUMBER, END_NUMBER, COUNT_NUMBER
            );
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

}
