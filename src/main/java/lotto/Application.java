package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Configuration;

public class Application {
    public static void main(String[] args) {
        try {
            Configuration.createLottoController().run();
        } finally {
            Console.close();
        }
    }
}
