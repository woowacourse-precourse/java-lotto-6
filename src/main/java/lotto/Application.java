package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.run.PlayLotto;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        try {
            new PlayLotto(new LottoView()).run();
        } finally {
            Console.close();
        }
    }
}
