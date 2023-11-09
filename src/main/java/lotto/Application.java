package lotto;

import java.lang.reflect.Proxy;
import lotto.controller.Counter;
import lotto.controller.ExceptionHandler;
import lotto.controller.LottoController;
import lotto.controller.LottoCounter;
import lotto.domain.ProfitCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Counter counter =(Counter) Proxy.newProxyInstance(
                Counter.class.getClassLoader(),
                new Class[]{Counter.class},
                new ExceptionHandler(new LottoCounter()));

        LottoController controller = new LottoController(new ProfitCalculator(),counter);
        controller.run();
    }
}
