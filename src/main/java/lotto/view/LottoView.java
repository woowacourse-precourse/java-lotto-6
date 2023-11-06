package lotto.view;

import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class LottoView implements View {
    private LottoView() {
    }

    public static LottoView create() {
        return new LottoView();
    }

    @Override
    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    @Override
    public String askPurchaseAmount() {
        printMessage(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
