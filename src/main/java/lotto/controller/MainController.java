package lotto.controller;

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
        // 로또 구입 금액 입력
        String inputMoney = inputView.readLottoMoney();
        // 로또 구매 수량 출력
        int lottoAmount = Validator.validateMoneyIsValid(inputMoney);
        outputView.printLottoMoney(lottoAmount);
        // 수량만큼 로또 생성 후 로또번호 출력

        // 당첨번호 입력

        // 보너스번호 입력
        String inputBonus = inputView.readBonusNumber();
        int bonusNumber = Validator.validateBonusNumber(inputBonus);

        // 당첨내역 출력

        // 수익률 출력
    }
}
