package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoWallet;

public class ConsoleLottoView implements LottoView {

    enum Message {
        PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
        PURCHASE_DISPLAY_MESSAGE_SUFFIX("개를 구매했습니다."),
        NOT_NUMBER_ERROR_MESSAGE("숫자를 입력해 주세요."),
        WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
        RESULT_DISPLAY_MESSAGE("당첨 통계"),
        ERROR_MESSAGE_PREFIX("[ERROR]");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Override
    public Integer getPurchaseAmount() {
        display(Message.PURCHASE_AMOUNT_MESSAGE.getMessage());

        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            display(Message.ERROR_MESSAGE_PREFIX.getMessage() + Message.NOT_NUMBER_ERROR_MESSAGE.getMessage());
            return getPurchaseAmount();
        }
    }

    @Override
    public void displayPurchased(LottoWallet lottoWallet) {
        display(lottoWallet.getLottoCount() + Message.PURCHASE_DISPLAY_MESSAGE_SUFFIX.getMessage());

        for (int i = 0; i < lottoWallet.getLottoCount(); i++) {
            display(lottoWallet.getSingleLottoNumbers(i).toString());
        }
    }

    @Override
    public List<Integer> getWinningNumbers() {
        display(Message.WINNING_NUMBER_INPUT_MESSAGE.getMessage());

        return Arrays.stream(input().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public Integer getBonusNumber() {
        display(Message.BONUS_NUMBER_INPUT_MESSAGE.getMessage());

        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            display(Message.ERROR_MESSAGE_PREFIX.getMessage() + Message.NOT_NUMBER_ERROR_MESSAGE.getMessage());
            return getBonusNumber();
        }
    }

    @Override
    public void displayResult(HashMap<String, Integer> result) {

    }

    @Override
    public void displayError(String message) {
        display(Message.ERROR_MESSAGE_PREFIX.getMessage() + message);
    }

    private void display(String message) {
        System.out.println(message);
    }

    private String input() {
        try {
            return Console.readLine();
        } catch (IllegalStateException e) {
            display(Message.ERROR_MESSAGE_PREFIX.getMessage() + e.getMessage());
            return input();
        }
    }
}
