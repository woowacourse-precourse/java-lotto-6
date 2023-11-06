package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPlayerNumbers {

    private final List<LottoPlayerNumber> LottoPlayerNumbers;

    public LottoPlayerNumbers(int numberOfLottoTickets) {
        this.LottoPlayerNumbers = generateLottoPlayerNumbers(numberOfLottoTickets);
    }

    public List<LottoPlayerNumber> getLottoPlayerNumbers() {
        return LottoPlayerNumbers;
    }

    private List<LottoPlayerNumber> generateLottoPlayerNumbers(int numberOfLottoTickets) {
        List<LottoPlayerNumber> lottoPlayerNumbers = new ArrayList<>();

        for (int count = 0; count < numberOfLottoTickets; count++) {
            lottoPlayerNumbers.add(new LottoPlayerNumber());
        }
        return lottoPlayerNumbers;
    }
}
