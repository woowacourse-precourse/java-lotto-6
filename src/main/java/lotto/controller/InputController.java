package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoService;
import lotto.model.PlayerLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {

    public void getLottomoney() {
        // 구입금액 입력
        String inputMoney = InputView.readLottoMoney();
        LottoAmount lottoAmount = new LottoAmount(inputMoney);
        OutputView.printLottoAmount(lottoAmount);
        PlayerLottos playerLottos = new PlayerLottos(lottoAmount.getLottoAmount());
    }

    public void getLottoNumber() {
        // 당첨번호 입력
        String lottoNumber = InputView.readLottoNumber();
        List<Integer> lottoNumbers = LottoService.validateInputLottoNumber(lottoNumber);
        Lotto lotto = new Lotto(lottoNumbers);
    }

    public void getBonusNumber() {
        // 보너스번호 입력
        String inputBonus = InputView.readBonusNumber();
        int bonusNumber = LottoService.validateBonusNumber(inputBonus);
    }
}
