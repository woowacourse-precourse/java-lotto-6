package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.User;
import lotto.io.InputStream;
import lotto.io.OutputStream;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final int ZERO = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final User user;
    private final LottoSeller seller;

    public LottoController(InputStream inputStream, OutputStream outputStream) {
        this.inputView = new InputView(inputStream);
        this.outputView = new OutputView(outputStream);
        this.user = User.createByBudget(ZERO);
        this.seller = LottoSeller.create();
    }

    public void inputMoney() {
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                int money = inputView.inputMoney();
                user.setBudget(money);
                break;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
        outputView.printEmptyLine();
    }

    public void buyLottos() {
        int money = user.pay();
        List<Lotto> lottos = seller.sellLottos(money);
        user.setLottos(lottos);
        outputView.printBuyMessage(lottos.size());
        lottos.forEach(lotto -> outputView.print(lotto.toString()));
        outputView.printEmptyLine();
    }
}