package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSalesMachine lottoSalesMachine = new LottoSalesMachine();
        List<Lotto> lottos;

        while (true) {
            try {
                lottos = lottoSalesMachine.buyLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine();
        WinningLotto winningLotto;

        winningLotto = lottoDrawMachine.drawWinningLotto();
        System.out.println();
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        lottoResult.printResult();
    }
}
