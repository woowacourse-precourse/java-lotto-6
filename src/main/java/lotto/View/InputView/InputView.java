package lotto.View.InputView;

import lotto.View.GeneralInputOutput.Input;
import lotto.View.GeneralInputOutput.Output;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";

    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private final Input GeneralInput = new Input();
    private final Output GeneralOutput = new Output();


    public String getLottoPurchaseAmount() {
        GeneralOutput.stringPrintln(PURCHASE_AMOUNT_PROMPT);
        return GeneralInput.stringInput();
    }

    public String getLottoWinningNumber() {
        GeneralOutput.stringPrintln(WINNING_NUMBER_PROMPT);
        return GeneralInput.stringInput();
    }

    public String getLottoBonusNumber() {
        GeneralOutput.stringPrintln(BONUS_NUMBER_PROMPT);
        return GeneralInput.stringInput();
    }

    /**
     * 유저 입력에 대해 뷰에서 검증할 목록
     * 값이 비어 있지 않은지
     * ","러 구분 되어 있는지
     */


}
