package lotto.model;

import java.util.List;
import lotto.util.InputUtil;

public class LottoService {

    private final LottoGenerator generator = LottoGenerator.getInstance();
    private final InputUtil inputUtil = InputUtil.getInstance();
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private User user;

    public void startService(User buyer) {
        this.user = buyer;
        sellLotto(buyer);
        generateWinningLotto();
    }

    private void sellLotto(User buyer) {
        buyer.enterDraw(inputUtil.inputMoney());
    }

    private void generateWinningLotto() {
        List<Integer> winningNumbers = inputUtil.inputWinningNumbers();
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(inputUtil.inputBonusNumber());
    }

}