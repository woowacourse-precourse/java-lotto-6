package lotto.domain.lotto;

import java.util.List;
import java.util.Optional;
import lotto.domain.ball.Ball;
import lotto.domain.lotto.validator.LottoValidator;
import lotto.domain.rank.Rank;
import lotto.mapper.BallMapper;

public class Lotto {

    private final List<Ball> balls;

    public Lotto(final List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.balls = generateBalls(sortNumbers(numbers));
    }

    private List<Ball> generateBalls(final List<Integer> numbers) {
        return numbers.stream()
                .map(BallMapper::getBall)
                .toList();
    }

    private List<Integer> sortNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public int countMatches(final List<Ball> another) {
        return (int) this.balls.stream()
                .filter(another::contains)
                .count();
    }

    public Optional<Rank> calculateRank(final Lotto lotto, final Ball bonus) {
        final int matchedCount = lotto.countMatches(this.balls);
        final boolean matchedBonus = this.balls.contains(bonus);
        return Rank.of(matchedCount, matchedBonus);
    }

    public List<String> parseString() {
        return balls.stream()
                .map(Ball::getNumber)
                .map(String::valueOf)
                .toList();
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
