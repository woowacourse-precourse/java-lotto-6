package lotto.domain.player;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoPrize;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

class PlayerLotto {

    private static final String UNKNOWN_LOTTOS_MESSAGE = "알 수 없는 로또 목록으로 사용자 로또를 생성할 수 없습니다.";
    private static final String UNKNOWN_ANSWER_MESSAGE = "유효한 정답 로또를 입력해주세요.";
    private static final String NULL_INCLUDED_LOTTOS_MESSAGE = "알 수 없는 로또가 포함된 로또 목록으로 사용자 로또를 생성할 수 없습니다.";
    private static final String BONUS_INCLUDED_ANSWER_MESSAGE = "정답 로또에 이미 포함된 번호는 보너스 번호로 사용할 수 없습니다.";
    private static final long TOTAL_RETURN_INITIAL_VALUE = 0L;
    private static final int PRIZE_STATISTICS_INITIAL_COUNT = 0;

    private final List<Lotto> lottos;

    private PlayerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PlayerLotto from(List<Lotto> lottos) {
        validate(lottos);

        return new PlayerLotto(lottos);
    }

    private static void validate(List<Lotto> lottos) {
        checkLottosNonNull(lottos);
        checkLottosNullIncluded(lottos);
    }

    private static void checkLottosNonNull(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException(UNKNOWN_LOTTOS_MESSAGE);
        }
    }

    private static void checkLottosNullIncluded(List<Lotto> lottos) {
        if (isNullIncluded(lottos)) {
            throw new IllegalArgumentException(NULL_INCLUDED_LOTTOS_MESSAGE);
        }
    }

    private static boolean isNullIncluded(List<Lotto> lottos) {
        return lottos.stream().anyMatch(Objects::isNull);
    }

    public EnumMap<LottoPrize, Integer> generateStatistics(Lotto answer, LottoNumber bonus) {
        validate(answer, bonus);

        return raffleAll(answer, bonus);
    }

    private void validate(Lotto answer, LottoNumber bonus) {
        checkAnswerNonNull(answer);
        checkAnswerBonusIncluded(answer, bonus);
    }

    private void checkAnswerNonNull(Lotto answer) {
        if (Objects.isNull(answer)) {
            throw new IllegalArgumentException(UNKNOWN_ANSWER_MESSAGE);
        }
    }

    private void checkAnswerBonusIncluded(Lotto answer, LottoNumber bonus) {
        if (answer.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_INCLUDED_ANSWER_MESSAGE);
        }
    }

    private EnumMap<LottoPrize, Integer> raffleAll(Lotto answer, LottoNumber bonus) {
        EnumMap<LottoPrize, Integer> statistics = createEmptyStatistics();
        for (Lotto lotto : lottos) {
            LottoPrize prize = raffle(answer, bonus, lotto);
            statistics.put(prize, statistics.get(prize) + 1);
        }

        return statistics;
    }

    private EnumMap<LottoPrize, Integer> createEmptyStatistics() {
        EnumMap<LottoPrize, Integer> statistics = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            statistics.put(prize, PRIZE_STATISTICS_INITIAL_COUNT);
        }

        return statistics;
    }

    private LottoPrize raffle(Lotto answer, LottoNumber bonus, Lotto lotto) {
        return LottoPrize.of(lotto.matchWith(answer), lotto.contains(bonus));
    }

    public Money calculateTotalReturn(Lotto answer, LottoNumber bonus) {
        EnumMap<LottoPrize, Integer> statistics = generateStatistics(answer, bonus);
        long totalReturn = calculateTotalReturn(statistics);

        return Money.from(totalReturn);
    }

    private long calculateTotalReturn(EnumMap<LottoPrize, Integer> statistics) {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> calculatePrizeReward(statistics, prize))
                .reduce(TOTAL_RETURN_INITIAL_VALUE, Long::sum);
    }

    private long calculatePrizeReward(EnumMap<LottoPrize, Integer> statistics, LottoPrize prize) {
        return (long) prize.getReward() * statistics.get(prize);
    }
}
