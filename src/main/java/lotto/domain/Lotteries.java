package lotto.domain;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lotteries {

    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    private Lotteries(List<Lotto> lottos) {
        this.lottos = Objects.requireNonNull(lottos);
    }

    public static Lotteries from(int purchaseAmount) {
        validate(purchaseAmount);
        int countOfLotto = purchaseAmount / LOTTO_PRICE;
        return new Lotteries(RandomLottoGenerator.generate(countOfLotto));
    }

    private static void validate(int purchaseAmount) {
        validatePositive(purchaseAmount);
        validatePrice(purchaseAmount);
    }

    private static void validatePositive(int purchaseAmount) {
        if (isNegativeOrZero(purchaseAmount)) {
            throw new IllegalArgumentException("구입 금액 양수 이어야 합니다");
        }
    }

    private static boolean isNegativeOrZero(int purchasePrice) {
        return purchasePrice <= 0;
    }

    private static void validatePrice(int purchaseAmount) {
        if (isNotDividedByLottoPrice(purchaseAmount)) {
            String exceptionMessage = "구입 금액은 한 장의 가격(%d)으로 나누어 떨어져야 합니다".formatted(LOTTO_PRICE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private static boolean isNotDividedByLottoPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public Map<WinningRank, Integer> makeWinningStatistics(WinningNumber winningNumber) {
        return lottos.stream().map(Lotto::getNumbers)
                .collect(groupingBy(numbers -> checkRank(winningNumber, numbers), summingInt(e -> 1)));
    }

    private WinningRank checkRank(WinningNumber winningNumber, List<Number> numbers) {
        int countOfCorrect = winningNumber.countMatchingWinningNumber(numbers);
        boolean isBonusCorrect = winningNumber.isMatchingBonusNumber(numbers);
        return WinningRank.from(countOfCorrect, isBonusCorrect);
    }

    public List<List<Integer>> getValues() {
        return lottos.stream().map(Lotto::getValues).toList();
    }

    public int getLottoPrice() {
        return LOTTO_PRICE;
    }

    @Override
    public String toString() {
        return "Lotteries{lottos=%s}".formatted(lottos);
    }
}
