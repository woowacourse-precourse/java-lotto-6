package lotto;

import java.util.List;

public class LottoController {

    private static final Wallet wallet = new Wallet();

    private static final LottoView view = new LottoView();


    void inputAmountOfLotto() {

        try {
            int amount = view.inputNumber("구입금액을 입력해 주세요.");
            wallet.addBalance(amount);

        } catch (Exception e) {
            view.printMessage(e.getMessage());
            inputAmountOfLotto();

            return;
        }

        view.printMessage("");
    }

    void buyLotto() {

        wallet.buyAllLotto();

        List<Lotto> lottos = wallet.getLottos();

        view.printMessage(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            view.printMessage(lotto.getNumbers().toString());
        }

        view.printMessage("");
    }
}
