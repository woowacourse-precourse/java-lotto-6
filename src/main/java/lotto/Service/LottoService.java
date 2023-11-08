package lotto.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Money;
import lotto.Domain.LottoNumbers;

public class LottoService {

    private static final int STANDARD_UNIT = 1000;

    public List<LottoNumbers> generateLottoNumbers(Money money) {
        int purchaseAmount = money.getPurchaseAmount();
        int numberOfTickets = purchaseAmount / STANDARD_UNIT;
        List<LottoNumbers> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoTickets.add(lottoNumbers);
        }

        return lottoTickets;
    }

}