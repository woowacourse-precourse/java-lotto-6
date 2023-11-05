package lotto;

public class LottoController {

    public void run() {
        Money money = Money.of(InputView.collectionOfMoney());

        Lottos lottos = Lottos.from(money.calcBillCount());
        LottoService service = new LottoService(lottos);

        OutputView.printPurchaseHistory(lottos.getList());
    }

}
