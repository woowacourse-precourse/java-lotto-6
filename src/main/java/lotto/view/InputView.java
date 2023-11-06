package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String PAID_AMOUNT_REQUEST_PROMPT = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBERS_REQUEST_PROMPT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_REQUEST_PROMPT = "보너스 번호를 입력해 주세요.";

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void requestPaidAmount() {
        request(PAID_AMOUNT_REQUEST_PROMPT);
    }

    public void requestWinningNumbers() {
        request(WINNING_NUMBERS_REQUEST_PROMPT);
    }

    public void requestBonusNumber() {
        request(BONUS_NUMBER_REQUEST_PROMPT);
    }

    private void request(String requestPrompt) {
        outputView.print(requestPrompt);
        Console.readLine();
    }
}
