package lotto.collaboration.lottos;

import java.util.List;
import java.util.stream.IntStream;
import lotto.io.Input;
import lotto.io.Output;
import lotto.io.lottos.LottosRandoms;

public class Lottos {

    public static final int MIN_PURCHASE_AMOUNT = 1_000;
    public static final int MAX_PURCHASE_AMOUNT = 100_000;
    private int purchaseAmount;
    private List<Lotto> purchaseLottos;

    public void purchase() {
        Output.consoleLine("구입금액을 입력해 주세요.");
        purchaseAmount = Input.consoleNumber();
        validatePurchaseAmount();
    }

    public void validatePurchaseAmount() {
        occurExceptionIfIndivisible();
        occurExceptionIfOutsideTheRange();
    }

    private void occurExceptionIfIndivisible() {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT + "원 단위로 입력해 주세요");
        }
    }

    private void occurExceptionIfOutsideTheRange() {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT ||
                MAX_PURCHASE_AMOUNT < purchaseAmount) {
            throw new IllegalArgumentException(
                    "로또 구매 금액은 " + MIN_PURCHASE_AMOUNT + "원에서 " + MAX_PURCHASE_AMOUNT + "원까지만 가능합니다.");
        }
    }

    public void make() {
        int ticketAmount = getTicketAmount();

        purchaseLottos = IntStream.range(0, ticketAmount)
                .mapToObj(i -> Lotto.make(new LottosRandoms()))
                .toList();
    }

    private int getTicketAmount() {
        return purchaseAmount / 1000;
    }

}
