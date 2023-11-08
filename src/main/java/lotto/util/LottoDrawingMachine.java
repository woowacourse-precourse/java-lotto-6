package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;

public class LottoDrawingMachine {


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
