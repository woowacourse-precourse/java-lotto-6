package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        int lottoNumber = purchaseAmount.input();

        LottoFactory factory = new LottoFactory(lottoNumber);
        List<Lotto> lottos = new ArrayList<>(factory.createLottos());

        WinningNumbersFactory setter = new WinningNumbersFactory();
        Lotto winningLotto = setter.setWinning();

        Performance performance = new Performance(lottos, winningLotto);
        performance.result();
    }
}
