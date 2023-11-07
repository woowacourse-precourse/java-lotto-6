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
        try {
            OutputView.buyLottoTicket();
            lotto.userInputMoney(InputView.userInput());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            userInputMoney();
        }
    }

    private void printLottoCount() {
        OutputView.getLottoCount(lotto.getTicketCount());
    }

    private void userInputLottoNumbers() {
        try {
            OutputView.numbersLotto();
            lotto.userInputNumbers(InputView.userInput());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            userInputLottoNumbers();
        }
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
        try {
            OutputView.bonusLotto();
            lotto.userInputBonus(InputView.userInput());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            userInputBonusNumber();
        }
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
        OutputView.printEarningRate(lotto.calculateEarningRate());
    }

    private void makeLuckyNumbers() {
        try {
            lotto.makeLuckyNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            userInputBonusNumber();
            makeLuckyNumbers();
        }
    }
}
