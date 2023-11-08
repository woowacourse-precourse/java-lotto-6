package lotto;

import java.util.List;

public class UserCase {

    private final LottoDrawMachine lottoDrawMachine;
    private final LottoSalesMachine lottoSalesMachine;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public UserCase(LottoDrawMachine lottoDrawMachine, LottoSalesMachine lottoSalesMachine) {
        this.lottoDrawMachine = lottoDrawMachine;
        this.lottoSalesMachine = lottoSalesMachine;
    }

    public void run() {
        buyLotto();
        System.out.println();
        drawWinningLotto();
        System.out.println();
        printResult();
    }

    private void buyLotto() {
        while (true) {
            try {
                this.lottos = lottoSalesMachine.buyLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(this.lottos.size() + "개를 구매했습니다.");
        this.lottos.forEach(System.out::println);
    }

    private void drawWinningLotto() {
        this.winningLotto = lottoDrawMachine.drawWinningLotto();
    }

    private void printResult() {
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        lottoResult.printResult();
    }
}
