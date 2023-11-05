package lotto.view;

import lotto.constant.Message;

public class LottoView implements View {
    private LottoView() {
    }

    public static LottoView create() {
        return new LottoView();
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
