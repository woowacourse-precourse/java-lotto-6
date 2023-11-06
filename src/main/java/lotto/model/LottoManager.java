package lotto.model;

import static lotto.model.RandomLottoGenerator.pickNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManager {
    private static final String WRONG_TYPE_OF_LOTTO = "[ERROR] 당첨 로또만 올 수 있습니다.";
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
        return new EarningRate(token.amount(), lottos.stream()
                .map(lotto -> answerLotto.contains(lotto))
                .map(Score::getPrize)
                .reduce(Integer::sum)
                .get());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
