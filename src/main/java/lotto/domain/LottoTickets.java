package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.utils.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(int numberOfTickets) {
        validateNumberOfTickets(numberOfTickets);

        lottoTickets = IntStream.range(0, numberOfTickets)
                .mapToObj(i -> new Lotto(LottoNumbersGenerator.generate()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoTickets() {
        return this.lottoTickets;
    }

    private void validateNumberOfTickets(int numberOfTickets) {
        if(numberOfTickets <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
    }
}
