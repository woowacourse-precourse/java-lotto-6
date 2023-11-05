package lotto.controller;

import lotto.constant.Message;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController(View view) {
        this.view = view;
    }

    public static LottoController from(View view) {
        return new LottoController(view);
    }

    public void run() {
        view.printMessage(Message.PURCHASE_AMOUNT_PROMPT);
    }
}
