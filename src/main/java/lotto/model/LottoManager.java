package lotto.model;

import static lotto.util.RandomNumberGenerator.pickNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManager {
    private static final String LINE_BREAK = "\n";
    private final Token token;
    private List<Lotto> lottos;
    private AnswerLotto answerLotto;

    public LottoManager(Token token) {
        this.token = token;
        this.lottos = new ArrayList<>();
    }

    public void ticket() {
        while (token.canTicket(ticketedCount())) {
            lottos.add(new Lotto(pickNumbers()));
        }
    }

    public int ticketedCount() {
        return lottos.size();
    }

    public boolean registerAnswerLotto(Lotto lotto) {
        if (!lotto.isAnswerLotto()) {
            return false;
        }
        this.answerLotto = (AnswerLotto) lotto;
        return true;
    }

    public EarningRate calEarningRate() {
        return new EarningRate(token.amount(), calScore());
    }

    public List<Score> calScore() {
        return lottos.stream()
                .map(lotto -> answerLotto.contains(lotto))
                .toList();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(LINE_BREAK)) + LINE_BREAK;
    }
}
