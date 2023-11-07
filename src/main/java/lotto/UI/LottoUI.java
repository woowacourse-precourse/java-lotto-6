package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.LottoPurchaseService;

import java.util.List;

public class LottoUI {
    private final LottoPurchaseService purchaseService = new LottoPurchaseService();

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lotto = purchaseService.purchaseLotto(purchaseAmount);
        displayPurchasedLotto(lotto);
    }

    private int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 구입 금액을 입력해야 합니다.");
        }
    }

    private void displayPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
