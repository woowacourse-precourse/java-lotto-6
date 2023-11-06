package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.LottoGenerator;
import lotto.util.RandomLottoGenerator;

public class LottoTicket {
    private Budget budget;
    private final List<Lotto> lottos;

    private LottoTicket(Budget budget, List<Lotto> lottos) {
        this.budget = budget;
        this.lottos = lottos;
    }

    public static LottoTicket create(int inputBudget) {
        Budget budget = new Budget(inputBudget);
        List<Lotto> lottos = makeLottos(budget);
        return new LottoTicket(budget, lottos);
    }

    private static List<Lotto> makeLottos(Budget budget) {
        int count = budget.makeTicket();
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> generateLottoNumbers() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoGenerator.generateNumber();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTicketCount() {
        return lottos.size();
    }
}
