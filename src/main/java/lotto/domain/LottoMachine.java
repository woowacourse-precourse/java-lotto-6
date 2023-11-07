package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class LottoMachine {

    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final int PURCHASE_UNIT = 1000;

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

}
