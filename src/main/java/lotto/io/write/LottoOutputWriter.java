package lotto.io.write;

import static lotto.io.message.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;
import static lotto.io.message.OutputMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.number.Lotto;

public final class LottoOutputWriter {
    public static void showPurchaseAmountMessage() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void showPurchaseLottoCount(int count) {
        System.out.printf("%d%s\n", count, LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach(lotto ->
                System.out.println(lottoToString(lotto.getNumbers()))
        );
    }

    private static String lottoToString(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
