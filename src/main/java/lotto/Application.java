package lotto;

import lotto.controller.LottoController;
import lotto.model.DHLottery;
import lotto.model.Member;
import lotto.model.ScoreType;
import lotto.view.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Member member = new Member();
        DHLottery dhLottery = new DHLottery();
        LottoController lottoController = new LottoController(dhLottery, member);

        lottoController.run();
    }
}
