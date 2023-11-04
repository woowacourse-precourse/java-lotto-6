package lotto.model;

import static lotto.model.LottoPrize.*;
import static lotto.util.Constant.LOTTO_PRICE;
import static lotto.util.Constant.ZERO;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import lotto.util.NumbersGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createWith(final long money, final NumbersGenerator numbersGenerator) {
        long lottoTicketCount = money / LOTTO_PRICE.getValue();
        return new Lottos(createLottos(lottoTicketCount, numbersGenerator));
    }

    private static List<Lotto> createLottos(final long lottoTicketCount, final NumbersGenerator numbersGenerator) {
        return LongStream.range(ZERO.getValue(), lottoTicketCount)
                .mapToObj(lotto -> Lotto.createWith(numbersGenerator))
                .toList();
    }

    public int countFirstPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isFirstPrizeWinner(winningNumbers))
                .count();
    }

    public int countSecondPrizeWinners(final List<Integer> winningNumbers, final int bonusNumber) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isSecondPrizeWinner(winningNumbers, bonusNumber))
                .count();
    }


    public int countThirdPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isThirdPrizeWinner(winningNumbers))
                .count();
    }

    public int countFourthPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isFourthPrizeWinner(winningNumbers))
                .count();
    }

    public int countFifthPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.isFifthPrizeWinner(winningNumbers))
                .count();
    }

    public long calculateWinningTotalPrize(final List<Integer> winningNumbers, final int bonusNumber) {
        return calculateWinningPrize(FIRST_PRIZE, countFirstPrizeWinners(winningNumbers)) +
                calculateWinningPrize(SECOND_PRIZE, countSecondPrizeWinners(winningNumbers, bonusNumber)) +
                calculateWinningPrize(THIRD_PRIZE, countThirdPrizeWinners(winningNumbers)) +
                calculateWinningPrize(FOURTH_PRIZE, countFourthPrizeWinners(winningNumbers)) +
                calculateWinningPrize(FIFTH_PRIZE, countFifthPrizeWinners(winningNumbers));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
