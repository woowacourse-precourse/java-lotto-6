package lotto;

import java.util.List;
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
}
