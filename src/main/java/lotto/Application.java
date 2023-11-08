package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new LottoView(), new LottoMachine());
        controller.playLottoGame();
    }
}
