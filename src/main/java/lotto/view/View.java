package lotto.view;

import lotto.constant.Message;
import lotto.dto.LottoPurchaseDto;

public interface View {
    void printMessage(Message message);

    void printMessage(Message message, Object args);

    String askPurchaseAmount();

    void close();

    void printPurchaseQuantity(LottoPurchaseDto lottoPurchaseDto);
}
