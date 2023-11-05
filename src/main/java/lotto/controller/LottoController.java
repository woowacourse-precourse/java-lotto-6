package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lotto = new LottoService();

    public void run() {
        lottoMaking();
        userInputMaking();
        printResult();
    }

    private void lottoMaking() {
        userInputMoney();
        // 구입금액에 따른 예외 처리 및 로또 티켓 구매
        printLottoCount();
        // 로또 티켓의 개수만큼 반복 및 중복 없이 출력 (OutputView에 로또 출력 구현 필요)
        printLottoTicket();
    }

    private void userInputMoney() {
        OutputView.buyLottoTicket();
        lotto.userInputMoney(InputView.userInput());
    }

    private void printLottoCount() {
        OutputView.getLottoCount(lotto.getTicketCount());
    }

    private void userInputLottoNumbers() {
        OutputView.numbersLotto();
        lotto.userInputNumbers(InputView.userInput());
    }

    private void printLottoTicket() {
        OutputView.printLottoTicket(lotto.getLottoTickets());
    }

    private void userInputMaking() {
        userInputLottoNumbers();
        // 당첨번호 및 보너스번호 기억할 객체 선택
        userInputBonusNumber();
        // 당첨번호 및 보너스번호 예외 처리
        // 로또번호와 당첨번호 중복 처리
        makeLuckyNumbers();
    }

    private void userInputBonusNumber() {
        OutputView.bonusLotto();
        lotto.userInputBonus(InputView.userInput());
    }

    private void printResult() {
        makeResult();
        resultLotto();
        // 로또 티켓의 개수만큼 반복 및 당첨번호 및 보너스번호와 비교하여 결과 출력
    }

    private void makeResult() {
        lotto.makeWinningStatistics();
    }

    private void resultLotto() {
        OutputView.resultLotto();
        OutputView.printWinningStatistics(lotto.getWinningStatistics());
    }

    private void makeLuckyNumbers() {
        lotto.makeLuckyNumbers();
    }
}
