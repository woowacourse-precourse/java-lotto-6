package view;

import dto.LottoDto;
import util.message.OutputMessage;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottos(final List<LottoDto> lottoDtos, final int numberOfPurchased){
        System.out.println(String.format(OutputMessage.LOTTO_PURCHASE_COUNT.getValue(), numberOfPurchased));
        for (LottoDto lotto : lottoDtos) {
            System.out.println(lotto);
        }
    }
}
