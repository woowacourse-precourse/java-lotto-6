package lotto.view;

import lotto.configuration.Constants;
import lotto.configuration.Constants.Message;
import lotto.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static lotto.configuration.Constants.Config.SCALE;
import static lotto.configuration.Constants.Message.*;
import static lotto.configuration.Constants.Message.FIRST_IS;
import static lotto.domain.Rank.*;

public class OutputView {

    public void printLottos(Lottos lottos) {
        List<Lotto> randomLottos = lottos.getRandomLottos();

        printLottoCount(randomLottos.size());
        randomLottos.forEach(this::printLotto);
    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        println(numbers.toString());
    }

    public void printResult(Result result) {
        Map<Rank, Integer> store = result.getStore();

        println(SHOW_RESULT);
        println(FIFTH_IS + store.get(FIFTH) + Constants.Message.COUNT);
        println(FOURTH_IS + store.get(FOURTH) + Constants.Message.COUNT);
        println(THIRD_IS + store.get(THIRD) + Constants.Message.COUNT);
        println(SECOND_IS + store.get(SECOND) + Constants.Message.COUNT);
        println(FIRST_IS + store.get(FIRST) + Constants.Message.COUNT);
    }

    public void printRate(Rate rate) {
        double rewardRate = rate.getRate();

        BigDecimal bigDecimal = new BigDecimal(rewardRate);
        rewardRate = bigDecimal.setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
        println(Constants.Message.RATE_IS + rewardRate + Constants.Message.PERCENT);
    }

    public void printException(IllegalArgumentException e){
        println(e.getMessage());
    }

    private void printLottoCount(int lottoCount) {
        println("\n" + lottoCount + Message.BUY_LOTTO);
    }

    private void println(String message) {
        System.out.println(message);
    }


}
