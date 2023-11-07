package lotto.core.lottoBall.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lotto.core.lottoBall.domain.match.MatchLottoResult;
import lotto.core.lottoBall.exception.DuplicatedLottoBallException;
import lotto.core.lottoBall.exception.InvalidLottoBallSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

    @Test
    @DisplayName("로또 볼 모음 생성 테스트, 로또 볼은 오름차순으로 정렬 되어 있다.")
    void create() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(7);

        // when
        LottoBalls lottoBalls = new LottoBalls(balls, bonus);

        // then
        assertInstanceOf(LottoBalls.class, lottoBalls);
        int idx = 0;
        for (LottoBall ball : lottoBalls) {
            assertTrue(ball.match(numbers.get(idx++)));
        }
    }

    @Test
    @DisplayName("로또 볼 모음 생성 테스트, 로또 볼은 6개의 수를 받아야 한다.")
    void lotooNeed6Numbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(6);

        // when && then
        assertThrows(InvalidLottoBallSizeException.class, () -> {
            new LottoBalls(balls, bonus);
        });
    }

    @Test
    @DisplayName("로또 볼 모음 생성 테스트, 로또 볼은 중복될 수 없다.")
    void duplicateBalls() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(7);

        // when && then
        assertThrows(DuplicatedLottoBallException.class, () -> {
            new LottoBalls(balls, bonus);
        });
    }

    @Test
    @DisplayName("로또 볼 모음 생성 테스트, 보너스 볼은 로또 볼과 같은 수를 가질 수 없다.")
    void duplicateBonus() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(6);

        // when && then
        assertThrows(DuplicatedLottoBallException.class, () -> {
            new LottoBalls(balls, bonus);
        });
    }

    @Test
    @DisplayName("로또 볼 모음은 6개의 수를 받아서 일치 하는 볼의 개수와 보너스 획득 여부를 반환 한다.")
    void match() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(7);

        // when
        LottoBalls lottoBalls = new LottoBalls(balls, bonus);
        List<Integer> firstNumbers = numbers;
        List<Integer> secondNumbers = List.of(1, 2, 3, 4, 5, 7);
        MatchLottoResult first = lottoBalls.match(firstNumbers);
        MatchLottoResult second = lottoBalls.match(secondNumbers);

        // then
        Assertions.assertAll(
            () -> assertEquals(6, first.getMatchCount()),
            () -> assertFalse(first.isBonusMatch()),
            () -> assertEquals(5, second.getMatchCount()),
            () -> assertTrue(second.isBonusMatch())
        );
    }

    @Test
    @DisplayName("로또 볼 모음은 6개가 아닌 수에 대해 비교할 수 없다.")
    void notMatchBallSize() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<LottoBall> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(new LottoBall(number));
        }
        LottoBall bonus = new LottoBall(7);

        // when
        LottoBalls lottoBalls = new LottoBalls(balls, bonus);

        // then
        assertThrows(InvalidLottoBallSizeException.class, () -> {
            lottoBalls.match(List.of(1, 2, 3, 4, 5));
        });
    }
}