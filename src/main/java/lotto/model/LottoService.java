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
        generateWinningData();
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

    private void generateWinningData() {
        generateWinningLotto();
        generateBonusNumber(winningLotto.getLottoNumbers());
    }

    private void generateWinningLotto() {
        boolean isValidLotto = false;
        while (!isValidLotto) {
            List<Integer> winningNumbers = inputUtil.inputWinningNumbers();
            isValidLotto = isValidLottoNumber(winningNumbers);
        }
    }

    private boolean isValidLottoNumber(List<Integer> winningNumbers) {
        try {
            winningLotto = new Lotto(winningNumbers);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void generateBonusNumber(List<LottoNumber> lottoNumbers) {
        boolean isValidBonusNumber = false;
        while (!isValidBonusNumber) {
            int bonusNumber = inputUtil.inputBonusNumber(lottoNumbers);
            isValidBonusNumber = isValidBonusNumber(bonusNumber);
        }
    }

    private boolean isValidBonusNumber(int bonusNumberInput) {
        try {
            bonusNumber = new LottoNumber(bonusNumberInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public void drawLotto() {
        Judge judge = new Judge(winningLotto, bonusNumber, user);
        LottoResult drawResult = judge.draw();
        System.out.println(drawResult);
        System.out.println(judge.calculateReturnRate(drawResult, user.getMoney()));
    }
}