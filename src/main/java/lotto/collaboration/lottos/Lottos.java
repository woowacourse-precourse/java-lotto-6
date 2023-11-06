package lotto.collaboration.lottos;

import java.util.List;
import java.util.stream.IntStream;
import lotto.game.io.Randoms;

public class Lottos {

    public static final int MIN_PURCHASE_AMOUNT = 1_000;
    public static final int MAX_PURCHASE_AMOUNT = 100_000;
    private int purchaseAmount;
    private List<Lotto> purchaseLottos;

    public void purchase(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        occurExceptionIfIndivisibleOf(purchaseAmount);
        occurExceptionIfOutsideTheRangeOf(purchaseAmount);
    }

    private void occurExceptionIfIndivisibleOf(int purchaseAmount) {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT + "원 단위로 입력해 주세요");
        }
    }

    private void occurExceptionIfOutsideTheRangeOf(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT ||
                MAX_PURCHASE_AMOUNT < purchaseAmount) {
            throw new IllegalArgumentException(
                    "로또 구매 금액은 " + MIN_PURCHASE_AMOUNT + "원에서 " + MAX_PURCHASE_AMOUNT + "원까지만 가능합니다.");
        }
    }

    public List<Lotto> make(Randoms lottosRandoms) {
        int ticketAmount = getTicketAmount();

        // TODO : 동일한 로또 생성되는 경우 예외처리 필요함
        purchaseLottos = IntStream.range(0, ticketAmount)
                .mapToObj(i -> Lotto.make(lottosRandoms))
                .toList();

        return List.copyOf(purchaseLottos);
    }

    private int getTicketAmount() {
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

}
