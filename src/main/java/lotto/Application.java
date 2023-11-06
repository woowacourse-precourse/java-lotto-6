package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(
                new LottoGenerateMachine(1, 45, 6),
                new LottoDrawMachine()
        );

        lottoStore.startSelling();
        lottoStore.drawSetup();
        lottoStore.draw();
    }
}
