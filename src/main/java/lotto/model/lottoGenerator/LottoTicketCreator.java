package lotto.model.lottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

    public class LottoTicketCreator {
        private final LottoNumberGenerator numberGenerator;

        public LottoTicketCreator(LottoNumberGenerator numberGenerator) {
            this.numberGenerator = numberGenerator;
        }

        public List<List<Integer>> createLottoTickets(int numberOfTickets) {
            return IntStream.range(0, numberOfTickets)
                    .mapToObj(i -> numberGenerator.generateNumbers())
                    .collect(Collectors.toList());
        }
    }