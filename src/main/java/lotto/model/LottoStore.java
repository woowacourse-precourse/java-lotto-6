package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.RandomLottoGenerator;
import lotto.util.exception.InvalidPurchaseAmountException;

public class LottoStore {
    private final int lottoTicketPrice;
    private final RandomLottoGenerator lottoGenerator;

    public LottoStore(int lottoTicketPrice, RandomLottoGenerator lottoGenerator) {
        this.lottoTicketPrice = lottoTicketPrice;
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTickets purchaseRandomLottoTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfLottoTickets = purchaseAmount / lottoTicketPrice;
        return new LottoTickets(generateLottoTickets(numberOfLottoTickets));
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (!isMultipleOfTicketPrice(purchaseAmount) || !isValidPurchaseAmount(purchaseAmount)) {
            throw new InvalidPurchaseAmountException(purchaseAmount);
        }
    }

    private boolean isMultipleOfTicketPrice(int purchaseAmount) {
        return purchaseAmount % lottoTicketPrice == 0;
    }

    private boolean isValidPurchaseAmount(int purchaseAmount) {
        return purchaseAmount >= Constants.MIN_PURCHASE_AMOUNT;
    }

    private List<Lotto> generateLottoTickets(int numberOfLottoTickets) {
        return IntStream.range(0, numberOfLottoTickets)
                .mapToObj(i -> lottoGenerator.generate())
                .toList();
    }
}
