package lotto.model;

import java.util.List;
import lotto.util.InputUtil;

public class LottoService {

    private final InputUtil inputUtil = InputUtil.getInstance();
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private User user;

    public void startService(User buyer) {
        this.user = buyer;
        sellLotto(buyer);
        generateWinningLotto();
        List<Lotto> purchasedLotto = user.getPurchasedLotto();
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
        System.out.println("===============");
        System.out.println(winningLotto);
        System.out.println(bonusNumber);
    }

    private void sellLotto(User buyer) {
        buyer.enterDraw(inputUtil.inputMoney());
    }

    private void generateWinningLotto() {
        List<Integer> winningNumbers = inputUtil.inputWinningNumbers();
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(inputUtil.inputBonusNumber());
    }

    public void drawLotto() {
        Judge judge = new Judge(winningLotto, bonusNumber, user);
        LottoResult draw = judge.draw();
        System.out.println(draw);
    }
}