package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSalesMachine lottoSalesMachine = new LottoSalesMachine();
        List<Lotto> lottos = lottoSalesMachine.buyLotto();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);

        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        WinningLotto winningLotto = lottoDrawMachine.drawWinningLotto();

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        lottoResult.printResult();
    }
}
