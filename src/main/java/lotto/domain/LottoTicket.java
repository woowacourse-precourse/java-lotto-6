package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.LottoGenerator;
import lotto.util.RandomLottoGenerator;

public class LottoTicket {
    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket create(int inputBudget) {
        Budget budget = new Budget(inputBudget);
        List<Lotto> lottos = makeLottos(budget);
        return new LottoTicket(lottos);
    }

    private static List<Lotto> makeLottos(Budget budget) {
        int count = budget.makeTicket();
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> generateLottoNumbers() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        return lottoGenerator.generateNumber()
                .stream()
                .sorted()
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTicketCount() {
        return lottos.size();
    }
}
