package lotto;

import java.util.List;
import java.util.Objects;
import lotto.util.Validator;

public class LottoGameController {

    public Lottos purchaseLotto(long buyCash) {
        LottoService service = new LottoService();
        long buyAmount = service.getLottoAmount(buyCash);

        List<Lotto> lottos = LottoGenerator.INSTANCE.generate((int) buyAmount);

        return new Lottos(lottos);
    }

    public Lotto generateWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public void validateBonusNumber(Lotto winningLotto, long inputBonusNumber) {
        Validator validator = Validator.INSTANCE;
        if (validator.isOutOfRange(inputBonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (winningLotto.isContains((int) inputBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Result getResult(Lottos lottos, WinningLotto winningLotto) {
        Result result = new Result();

        lottos.getLottoTickets().stream()
                .map(winningLotto::getRank)
                .filter(Objects::nonNull)
                .forEach(result::addRank);

        return result;
    }
}
