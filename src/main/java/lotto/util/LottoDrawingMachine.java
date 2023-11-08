package lotto.util;

import static lotto.message.ErrorMessages.INVALID_DUPLICATION_LOTTO_BALL_AND_BONUS_BALL;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public class LottoDrawingMachine {

    private Lotto lotto;
    private LottoBall lottoBall;

    public LottoDrawingMachine(Lotto lottoNumbers, LottoBall bonusBall) {
        validateDuplicationNumbers(lottoNumbers, bonusBall);
        this.lotto = lottoNumbers;
        this.lottoBall = bonusBall;
    }

    private void validateDuplicationNumbers(Lotto lottoNumbers, LottoBall bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_LOTTO_BALL_AND_BONUS_BALL.getMessage());
        }
    }

    public static Lotto LottoDrawingMachine(final List<String> lottoBalls) {

        return new Lotto(lottoBalls.stream()
                .map(LottoDrawingMachine::makeBall)
                .map(LottoBall::toInt)
                .collect(Collectors.toList()));
    }



    private static LottoBall makeBall(final String lottoBall){
        return new LottoBall(lottoBall);
    }
}
