package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoService;
import lotto.model.PlayerLottos;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String inputMoney = inputView.readLottoMoney();
        LottoAmount lottoAmount = new LottoAmount(inputMoney);
        outputView.printLottoAmount(lottoAmount);
        PlayerLottos playerLottos = new PlayerLottos(lottoAmount.getLottoAmount());

 //        당첨번호 입력
        String lottoNumber = inputView.readLottoNumber();
        List<Integer> lottoNumbers = LottoService.validateInputLottoNumber(lottoNumber);

        // 보너스번호 입력
//        String inputBonus = inputView.readBonusNumber();
//        int bonusNumber = Validator.validateBonusNumber(inputBonus);

        // 당첨내역 출력

        // 수익률 출력
    }
}
