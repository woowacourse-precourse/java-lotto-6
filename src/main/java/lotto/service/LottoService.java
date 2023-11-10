package lotto.service;

import static lotto.LottoRule.LOTTO_NUMBER_COUNT;
import static lotto.LottoRule.LOTTO_NUMBER_END;
import static lotto.LottoRule.LOTTO_NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.dto.LottoTicket;

public class LottoService {
    private RankingService rankingService;
    private List<Lotto> lottos;
    private Payment payment;

    public void setRankingService(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    public void buyTickets(int price) {
        initPayment(price);
        initLottos(createLottos(payment.getLottoCount()));
    }

    public void initPayment(int payment) {
        this.payment = new Payment(payment);
    }

    public void initLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < size) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START.value(), LOTTO_NUMBER_END.value(),
                        LOTTO_NUMBER_COUNT.value()));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public void play() {
        lottos.forEach(lotto -> rankingService.savePlayResult(lotto));
    }

    public List<LottoTicket> tickets() {
        return lottos.stream().map(Lotto::toLottoTicket).toList();
    }

    public int getPayment() {
        return payment.getPayment();
    }
}
