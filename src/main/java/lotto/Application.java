package lotto;

import lotto.scenario.LottoScenario;
import lotto.scenario.Scenario;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scenario scenario = new LottoScenario();
        scenario.play();
    }
}
