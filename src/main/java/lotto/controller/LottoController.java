package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lotto = new LottoService();

    public void run() {
        userInputMoney();
        // 구입금액에 따른 예외 처리 및 로또 티켓 구매
        printLottoTicket();
        // 로또 티켓의 개수만큼 반복 및 중복 없이 출력 (OutputView에 로또 출력 구현 필요)
        userInputLottoNumbers();
        // 당첨번호 및 보너스번호 기억할 객체 선택
        userInputBonusNumber();
        // 당첨번호 및 보너스번호 예외 처리
        resultLotto();
        // 로또 티켓의 개수만큼 반복 및 당첨번호 및 보너스번호와 비교하여 결과 출력
    }

    private void userInputMoney() {
        OutputView.buyLottoTicket();
        System.out.println(InputView.userInput());
    }

    private void printLottoTicket() {
        OutputView.getLottoTicket(5);
    }

    private void userInputLottoNumbers() {
        OutputView.numbersLotto();
        System.out.println(InputView.userInput());
    }

    private void userInputBonusNumber() {
        OutputView.bonusLotto();
        System.out.println(InputView.userInput());
    }

    private void resultLotto() {
        OutputView.resultLotto();
    }
}
