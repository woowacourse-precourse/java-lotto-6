package lotto.model;

import static lotto.model.RandomLottoGenerator.pickNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManager {
    private final Token token;
    private List<Lotto> lottos;
    private AnswerLotto answerLotto;

    public LottoManager(int amount) {
        this.token = new Token(amount);
        this.lottos = new ArrayList<>();
    }

    public void ticket() {
        while (token.canTicket(lottos.size())) {
            lottos.add(new Lotto(pickNumbers()));
        }
    }

    public boolean registerAnswerLotto(Lotto lotto) {
        if (!lotto.isAnswerLotto()) {
            return false;
        }
        this.answerLotto = (AnswerLotto) lotto;
        return true;
    }

    public EarningRate calEarningRate() {
        int earning = lottos.stream()
                .map(lotto -> answerLotto.contains(lotto))
                .map(Score::getPrize)
                .reduce(Integer::sum)
                .get();

        return new EarningRate(token.amount(), earning);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
