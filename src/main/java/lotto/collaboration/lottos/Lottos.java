package lotto.collaboration.lottos;

import java.util.List;
import java.util.stream.IntStream;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Randoms;

public class Lottos {

    public static final int MIN_PURCHASE_AMOUNT = 1_000;
    public static final int MAX_PURCHASE_AMOUNT = 100_000;
    private int purchaseAmount;
//    private List<Lotto> purchaseLottos;

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

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<PlayerLotto> make(Randoms lottosRandoms) {
        int ticketAmount = getTicketAmount();

        while (true) {
            List<PlayerLotto> playerLottos = IntStream.range(0, ticketAmount)
                    .mapToObj(i -> new PlayerLotto(Lotto.make(lottosRandoms).stream().toList()))
                    .toList();
            if (playerLottos.size() == playerLottos.stream().distinct().count()) {
                return playerLottos;
            }
        }

    }

    private int getTicketAmount() {
        return purchaseAmount / MIN_PURCHASE_AMOUNT;
    }

}
