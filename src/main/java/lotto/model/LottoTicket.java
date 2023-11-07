package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;
import lotto.util.Validator;

public class LottoTicket {

    private final List<Lotto> lottoEntries = new ArrayList<>();

    public LottoTicket(final int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            Validator.validate(numbers);
            this.lottoEntries.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottoEntries() {
        return lottoEntries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoEntries) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }
}
