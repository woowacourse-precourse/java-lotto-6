package lotto.domain;

import static lotto.constant.LottoConstant.MONEY_UNIT;
import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.Rank;
import lotto.exception.LottoException;

public class LottoFactory {

    private static final int ZERO = 0;
    private final List<Lotto> lottos;

    private LottoFactory(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoFactory create(final NumberGenerator numberGenerator, final int money) {
        return new LottoFactory(createLottos(numberGenerator, money));
    }

    private static List<Lotto> createLottos(final NumberGenerator numberGenerator, final int money) {
        validateMoney(money);

        final int lottoCount = getLottoCount(money);

        return Stream.generate(numberGenerator::generate)
                .limit(lottoCount)
                .map(Lotto::new)
                .toList();
    }

    private static int getLottoCount(int money) {
        return money / MONEY_UNIT.getValue();
    }

    private static void validateMoney(final int money) {
        if (isNotPositive(money)) {
            throw LottoException.of(NOT_ENOUGH_MONEY);
        }

        if (isNotCorrectUnit(money)) {
            throw LottoException.of(INVALID_UNIT);
        }
    }

    private static boolean isNotPositive(int money) {
        return money <= ZERO;
    }

    private static boolean isNotCorrectUnit(final int money) {
        return money % MONEY_UNIT.getValue() != 0;
    }

    public Result calculateResult(final AnswerLotto answerLotto) {
        return Result.of(lottos.stream()
                .collect(Collectors.toMap(answerLotto::getRank,
                        value -> 1L,
                        Long::sum,
                        getEnumMapSupplier())));

    }

    private Supplier<EnumMap<Rank, Long>> getEnumMapSupplier() {
        return () -> {
            EnumMap<Rank, Long> enumMap = new EnumMap<>(Rank.class);
            EnumSet.allOf(Rank.class)
                    .forEach(rank -> enumMap.put(rank, 0L));

            return enumMap;
        };
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }

}
