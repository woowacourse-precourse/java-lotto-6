package lotto.mapper;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.ball.Ball;

public class BallMapper {

    private static final Map<Integer, Ball> balls = new HashMap<>();

    private BallMapper() {
    }

    public static Ball getBall(final int ballNumber) {
        saveBallIfNotExist(ballNumber);
        return balls.get(ballNumber);
    }

    private static void saveBallIfNotExist(final int ballNumber) {
        if (balls.containsKey(ballNumber)) {
            return;
        }
        balls.put(ballNumber, new Ball(ballNumber));
    }
}
