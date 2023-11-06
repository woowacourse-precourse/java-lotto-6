package lotto.controller;

import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.model.Amount;

import static lotto.Message.ErrorMessage.VALUE_IS_NOT_CONVERT_INTEGER;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            //구입금액을 입력해 주세요.
            Amount amount = new Amount(Integer.parseInt(inputView.input()));
            //발행한 로또 수량 및 번호를 출력
            UserLotto userLotto = new UserLotto(amount.getLottoQuantity());
            //당첨번호 입력
            Lotto lotto = new Lotto(inputView.input());
            //보너스 번호 입력
            BonusLotto bonusLotto = new BonusLotto(Integer.parseInt(inputView.input()), lotto.getNumbers());
            //당첨 내역 출력
            LottoService lottoService = new LottoService(userLotto.getUserNumbers(), lotto.getNumbers(), bonusLotto.getBonusNumber());
            lottoService.compareLottoNumber();
            //총 수익률 출력
        } catch (NumberFormatException e) {
            throw new NumberFormatException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
        }


    }

}
