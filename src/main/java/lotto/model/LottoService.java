package lotto.model;

import java.util.List;
import lotto.model.domain.Judge;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.LottoResult;
import lotto.model.domain.User;
import lotto.util.InputUtil;
import lotto.util.message.ResultMessage;
import lotto.util.message.SystemMessage;

public class LottoService {

    private final InputUtil inputUtil = InputUtil.getInstance();
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private User user;

    public void startService(User buyer) {
        this.user = buyer;
        sellLotto(buyer);
        generateWinningData();
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
        SystemMessage.INPUT_WINNING_NUMBER.printMessage();
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
            return false;
        }
    }

    private void generateBonusNumber(List<LottoNumber> lottoNumbers) {
        SystemMessage.INPUT_BONUS_NUMBER.printMessage();
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
            return false;
        }
    }


    public void drawLotto() {
        Judge judge = new Judge(winningLotto, bonusNumber, user);
        LottoResult drawResult = judge.draw();
        System.out.println(drawResult);
        double returnRate = judge.calculateReturnRate(drawResult, user.getMoney());
        System.out.println(ResultMessage.RETURN_RATE.getReturnRate(returnRate));
    }
}