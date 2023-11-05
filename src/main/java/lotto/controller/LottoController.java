package lotto.controller;

import lotto.LottoFactory;
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
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
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
        } catch (NumberFormatException e) {
            throw new NumberFormatException(VALUE_IS_NOT_CONVERT_INTEGER.getMessage());
        }


    }

}
