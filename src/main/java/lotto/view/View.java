package lotto.view;

import lotto.constant.Message;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;

public interface View {
    void println(String string);

    void printMessage(Message message);

    void printMessage(Message message, Object args);

    String askPurchaseAmount();

    void close();

    void printPurchaseQuantity(LottoPurchaseDto lottoPurchaseDto);

    void printLottoNumbers(LottosDto lottosDto);

    String askWinningNumber();

    String askBonusNumber();
}
