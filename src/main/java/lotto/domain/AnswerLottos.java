package lotto.domain;

import java.util.List;
import lotto.exception.DuplicatedBonusBallException;

public class AnswerLottos {
    private final Lotto lotto;
    private final BonusBall bonusBall;

    public AnswerLottos(Lotto lotto, BonusBall bonusBall) {
        validate(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validate(Lotto lotto, BonusBall bonusBall) {
        if (lotto.isContain(bonusBall.getBall())) {
            throw new DuplicatedBonusBallException();
        }
    }

    public List<Result> match(LottoTicket lottoTicket) {
        List<Lotto> ticketLottos = lottoTicket.getLottos();

        return ticketLottos.stream()
                .map(lotto -> new Result(matchBall(lotto), matchBonus(lotto)))
                .toList();
    }

    private int matchBall(Lotto buyLottos) {
        List<Integer> answerLottos = lotto.getNumbers();

        return (int) answerLottos.stream()
                .filter(buyLottos::isContain)
                .count();
    }

    private boolean matchBonus(Lotto buyLottos) {
        return buyLottos.isContain(bonusBall.getBall());
    }
}
