package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoValidator;

import java.util.List;

public class InputView {
    private final LottoValidator lottoValidator;

    public InputView() {
        this.lottoValidator = new LottoValidator();
    }

    public int getPurchaseAmount() {
        return lottoValidator.checkPurchaseAmount(Console.readLine());
    }

    public List<Integer> getLottoNumber() {
        return lottoValidator.checkLottoNumber(Console.readLine());
    }

    public int getBonusNumber() {
        return lottoValidator.checkBonusNumber(Console.readLine());
    }

}
