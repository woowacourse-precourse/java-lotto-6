package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGame {

    private List<Lotto> lottos; // 구입한 로또

    private AmountValidator purchaseAmountValidator;

    public LottoGame(AmountValidator purchaseAmountValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
    }

    public void start() {
        int purchaseAmount = getPurchaseAmount();
    }

    /**
     * 구입 금액을 입력받는다.(유효한 금액을 입력할 때까지 반복)
     * @return 유효성이 검증된 구입 금액
     */
    private int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = Console.readLine();
            try {
                if (purchaseAmountValidator.isValid(purchaseAmountInput)) {
                    return Integer.parseInt(purchaseAmountInput);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("[ERROR] %s", e.getMessage()));
            }
        }
    }

}
