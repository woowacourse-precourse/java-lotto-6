package lotto.collaboration;

import static lotto.collaboration.enums.LottoStoreMessage.makeMessageForIndivisible;
import static lotto.collaboration.enums.LottoStoreMessage.makeMessageForOutOfRange;

import java.util.List;
import java.util.stream.IntStream;
import lotto.collaboration.dto.PlayerLotto;
import lotto.game.io.Randoms;

public class LottoStore {

    public static final int MIN_PURCHASE_AMOUNT = 1_000;
    public static final int MAX_PURCHASE_AMOUNT = 100_000;
    private int purchaseAmount;

    public void purchase(final int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        occurExceptionIfIndivisibleOf(purchaseAmount);
        occurExceptionIfOutsideTheRangeOf(purchaseAmount);
    }

    private void occurExceptionIfIndivisibleOf(int purchaseAmount) {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(makeMessageForIndivisible(MIN_PURCHASE_AMOUNT));
        }
    }

    private void occurExceptionIfOutsideTheRangeOf(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT
                || MAX_PURCHASE_AMOUNT < purchaseAmount) {
            throw new IllegalArgumentException(makeMessageForOutOfRange(MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT));
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<PlayerLotto> make(final Randoms lottosRandoms) {
        int ticketAmount = getTicketAmount();

        while (true) {
            List<PlayerLotto> playerLottos = IntStream.range(0, ticketAmount)
                    .mapToObj(i -> new PlayerLotto(Lotto.make(lottosRandoms)))
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
