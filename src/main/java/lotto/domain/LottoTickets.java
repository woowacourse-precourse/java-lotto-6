package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.utils.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(int numberOfTickets) {
        validateNumber(numberOfTickets);
        this.lottoTickets = generateRandomLottoTickets(numberOfTickets);
    }

    public static LottoTickets createdBy(int numberOfTickets) {
        return new LottoTickets(numberOfTickets);
    }

    public List<Lotto> getLottoTickets() {
        return this.lottoTickets;
    }

    private void validateNumber(int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
    }

    private List<Lotto> generateRandomLottoTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(i -> Lotto.valueOf(LottoNumbersGenerator.generate()))
                .toList();
    }
}
