package lotto.model;

import static lotto.util.Constant.FIVE;
import static lotto.util.Constant.FOUR;
import static lotto.util.Constant.SIX;
import static lotto.util.Constant.THREE;
import static lotto.util.Constant.ZERO;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.NumbersGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createWith(final int lottoTicketCount, final NumbersGenerator numbersGenerator) {
        return new Lottos(createLottos(lottoTicketCount, numbersGenerator));
    }

    private static List<Lotto> createLottos(final int lottoTicketCount, final NumbersGenerator numbersGenerator) {
        return IntStream.range(ZERO.getValue(), lottoTicketCount)
                .mapToObj(lotto -> Lotto.createWith(numbersGenerator))
                .toList();
    }

    public int countFirstPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> isFirstPrizeWinner(lotto.getNumbers(), winningNumbers))
                .count();
    }

    private boolean isFirstPrizeWinner(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        return countMatchingNumbers(lottoNumbers, winningNumbers) == SIX.getValue();
    }

    public int countSecondPrizeWinners(final List<Integer> winningNumbers, final int bonusNumber) {
        return (int) lottos.stream()
                .filter(lotto -> isSecondPrizeWinner(lotto.getNumbers(), winningNumbers, bonusNumber))
                .count();
    }

    private boolean isSecondPrizeWinner(final List<Integer> lottoNumbers, final List<Integer> winningNumbers,
                                        final int bonusNumber) {
        return countMatchingNumbers(lottoNumbers, winningNumbers) == FIVE.getValue() && lottoNumbers.contains(
                bonusNumber);
    }

    public int countThirdPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> isThirdPrizeWinner(lotto.getNumbers(), winningNumbers))
                .count();
    }

    private boolean isThirdPrizeWinner(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        return countMatchingNumbers(lottoNumbers, winningNumbers) == FIVE.getValue();
    }

    public int countFourthPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> isFourthPrizeWinner(lotto.getNumbers(), winningNumbers))
                .count();
    }

    private boolean isFourthPrizeWinner(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        return countMatchingNumbers(lottoNumbers, winningNumbers) == FOUR.getValue();
    }

    public int countFifthPrizeWinners(final List<Integer> winningNumbers) {
        return (int) lottos.stream()
                .filter(lotto -> isFifthPrizeWinner(lotto.getNumbers(), winningNumbers))
                .count();
    }

    private boolean isFifthPrizeWinner(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        return countMatchingNumbers(lottoNumbers, winningNumbers) == THREE.getValue();
    }


    private int countMatchingNumbers(final List<Integer> lottoNumbers, final List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
