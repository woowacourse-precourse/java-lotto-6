package lotto.view;

public class LottoMachineStaticDisplay {

    private static final String PROMPT_PURCHASE_LOTTO_AMOUNT = "구매금액을 입력해주세요.";
    private static final String PROMPT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";

    private LottoMachineStaticDisplay() {
    }

    public static void printPromptPurchaseLottoAmount() {
        System.out.println(PROMPT_PURCHASE_LOTTO_AMOUNT);
    }

    public static void printPromptWinningLottoNumber() {
        System.out.println(PROMPT_WINNING_LOTTO_NUMBER);
    }

    public static void printPromptBonusLottoNumber() {
        System.out.println(PROMPT_BONUS_LOTTO_NUMBER);
    }
}
