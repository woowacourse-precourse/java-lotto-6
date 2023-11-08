package lotto;

import output.Performance;
import purchaseAmount.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        WinningNumbersFactory setter = new WinningNumbersFactory();

        int lottoNumber = purchaseAmount.input();
        LottoFactory factory = new LottoFactory(lottoNumber);
        List<Lotto> lottos = new ArrayList<>(factory.createLottos());

        Lotto winningLotto = setter.setWinning();

        Performance performance = new Performance(lottos, winningLotto);
        performance.result();
    }
}
