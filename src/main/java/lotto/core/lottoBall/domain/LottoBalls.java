package lotto.core.lottoBall.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import lotto.core.lottoBall.domain.match.MatchLottoResult;
import lotto.core.lottoBall.exception.DuplicatedLottoBallException;
import lotto.core.lottoBall.exception.InvalidLottoBallSizeException;

public class LottoBalls implements Iterable<LottoBall> {

    private static final int LOTTO_BALL_SIZE = 6;

    private final List<LottoBall> balls;
    private final LottoBall bonus;

    public LottoBalls(List<LottoBall> balls, LottoBall bonus) {
        validate(balls, bonus);
        sort(balls);
        this.balls = balls;
        this.bonus = bonus;
    }

    private void validate(List<LottoBall> balls, LottoBall bonus) {
        validateBallsSize(balls);
        validateDuplicated(balls, bonus);
    }

    private void validateDuplicated(List<LottoBall> balls, LottoBall bonus) {
        List<LottoBall> allBalls = new ArrayList<>(balls);
        allBalls.add(bonus);
        List<LottoBall> target = new ArrayList<>();
        for (LottoBall ball : allBalls) {
            if (target.contains(ball)) {
                throw new DuplicatedLottoBallException();
            }
            target.add(ball);
        }
    }

    private void sort(List<LottoBall> balls) {
        balls.sort(LottoBall::compareTo);
    }

    private void validateBallsSize(List<?> balls) {
        if (!Objects.equals(balls.size(), LOTTO_BALL_SIZE)) {
            throw new InvalidLottoBallSizeException();
        }
    }

    @Override
    public Iterator<LottoBall> iterator() {
        return balls.iterator();
    }

    public MatchLottoResult match(List<Integer> numbers) {
        validate(numbers);
        int count = 0;
        boolean matchBonus = false;
        for (Integer number : numbers) {
            count = isMatchBall(number, count);
            matchBonus = isMatchBonus(number, matchBonus);
        }
        return new MatchLottoResult(count, matchBonus);
    }

    private void validate(List<Integer> numbers) {
        validateBallsSize(numbers);
    }

    private int isMatchBall(Integer number, int count) {
        for (LottoBall ball : balls) {
            if (ball.match(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatchBonus(Integer number, boolean matchBonus) {
        if (bonus.match(number)) {
            matchBonus = true;
        }
        return matchBonus;
    }
}
