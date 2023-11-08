package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE_PER_TICKET = 1000;

    public List<List<Integer>> createRandomLottoTickets(String inputBuyLottoAmount) {
        int buyLottoAmount = Integer.parseInt(inputBuyLottoAmount);
        int lottoTicketCount = buyLottoAmount / LOTTO_PRICE_PER_TICKET;

        List<List<Integer>> lottoTickets = new ArrayList<>();
        while (lottoTickets.size() < lottoTicketCount) {
            List<Integer> lottoNumbers = getLottoNumbers();
            Collections.sort(lottoNumbers);

            Lotto lottoTicket = new Lotto(lottoNumbers);
            if (!lottoTickets.contains(lottoTicket.getNumbers())) {
                lottoTickets.add(lottoTicket.getNumbers());
            }
        }
        return lottoTickets;
    }

    private List<Integer> getLottoNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE));
    }
}
