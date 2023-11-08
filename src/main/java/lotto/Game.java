package lotto;

import java.util.List;

public class Game {
    private Amount amount;
    private List<Lotto> lottos;
    private Output output = new Output();
    public void setAmount() {
        while(true) {
            try {
                this.amount = new Amount(Input.getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(Output.ERROR_MESSAGE_PREFIX + Output.LOTTO_PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        }
    }
    public void buyLotto(){
        lottos = Lotto.buyLotto(amount.getLottoCount());
        output.printLottoPurchaseCountMessage(amount.getLottoCount());
        output.printLottos(lottos);
    }
}
