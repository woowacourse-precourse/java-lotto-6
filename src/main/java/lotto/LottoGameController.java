package lotto;

import java.util.List;
import java.util.Objects;
import lotto.util.Validator;

public class LottoGameController {
    private final View view = new View();

    public BuyCash inputBuyCash() {
        return new BuyCash(view.inputBuyCashFromUser());
    }

    public Lottos purchaseLotto(BuyCash buyCash) {
        List<Lotto> lottos = LottoGenerator.INSTANCE.generate(buyCash.getLottoAmount());

        return new Lottos(lottos);
    }

    public void printBuyLottosInformation(Lottos lottos) {
        view.printUserLottos(lottos.getAllLottoNumbersMessage(), lottos.getLottoAmount());
    }

    public Lotto inputWinningLotto() {
        return generateWinningLotto(view.inputWinningNumbers());
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
