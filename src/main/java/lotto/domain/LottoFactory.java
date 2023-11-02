package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.Rank;
import lotto.exception.LottoException;

public class LottoFactory {
    private static final int UNIT = 1000;
    private static final int ZERO = 0;
    private final List<Lotto> lottos;

    private LottoFactory(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoFactory create(NumberGenerator numberGenerator, int money) {
        return new LottoFactory(createLottos(numberGenerator, money));
    }

    private static List<Lotto> createLottos(NumberGenerator numberGenerator , int money) {
        validateMoney(money);

        int lottoCount = money / UNIT;

        return Stream.generate(numberGenerator::generate)
                .limit(lottoCount)
                .map(Lotto::new)
                .toList();
    }

    private static void validateMoney(int money) {
        if (money <= ZERO) {
            throw LottoException.of(NOT_ENOUGH_MONEY);
        }

        if (isCorrectUnit(money)) {
            throw LottoException.of(INVALID_UNIT);
        }
    }

    private static boolean isCorrectUnit(int money) {
        return money % UNIT != 0;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public Map<Rank, Integer> calculateResult(Lotto answerLotto, int bonusNumber) {
        answerLotto.validateBonusNumber(bonusNumber);

        return lottos.stream()
                .map(lotto -> lotto.getRank(answerLotto, bonusNumber))
                .collect(Collectors.groupingBy());

    }
}
