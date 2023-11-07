package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoTickets(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        return generateLottoTickets(numberOfLottoTicketsToBuy);
    }

    public int calculateNumberOfLottoTicketsToBuy(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> generateLottoTickets(int numberOfTickets) {
        return Stream.generate(() -> generateUniqueLottoTicket())
                .limit(numberOfTickets)
                .collect(Collectors.toList());
    }

    private Lotto generateUniqueLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
