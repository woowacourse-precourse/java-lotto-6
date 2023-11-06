package lotto.view;

import lotto.constant.Message;

public interface View {
    void printMessage(Message message);

    String askPurchaseAmount();

    void close();
}
