package lotto.view;

public class LottoMachineDisplay {

    private static final String PROMPT_PURCHASE_LOTTO_AMOUNT = "구매금액을 입력해주세요.";

    private LottoMachineDisplay() {
    }

    public void printPromptPurchaseLottoAmount() {
        System.out.println(PROMPT_PURCHASE_LOTTO_AMOUNT);
    }
}
