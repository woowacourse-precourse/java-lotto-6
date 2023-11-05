package lotto.model;

import lotto.exception.Validation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchaseManager {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int purchaseAmount;
    private final int lottoTicketCount;
    private final List<LottoResult> winningTicket;
    private final List<Lotto> lottoTickets;

    public LottoPurchaseManager(int purchaseAmount,
                                int lottoTicketCount,
                                List<LottoResult> winningTicket,
                                LottoNumberGenerator lottoNumberGenerator) {
        Validation.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoTicketCount = lottoTicketCount;
        this.winningTicket = winningTicket;
        this.lottoTickets = generateLottoTickets(lottoNumberGenerator);
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public static int getLottoTicketPrice() {
        return LOTTO_TICKET_PRICE;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int calculateLottoTicketCount() {
        return this.purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public double calculateProfitRate() {
        double profitRate = ((double) calculateTotalPrize() / purchaseAmount) * 100;

        return roundToSecondDecimalPlace(profitRate);
    }

    private List<Lotto> generateLottoTickets(LottoNumberGenerator lottoNumberGenerator) {
        return IntStream.range(0, lottoTicketCount)
                .mapToObj(i -> lottoNumberGenerator.generateRandomLottoNumbers())
                .map(numbers -> numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private double roundToSecondDecimalPlace(double value) {
        return Math.round(value * 10) / 10.0;
    }

    private int calculateTotalPrize() {
        return winningTicket.stream()
                .mapToInt(LottoResult::getPrizeMoney)
                .sum();
    }
}
