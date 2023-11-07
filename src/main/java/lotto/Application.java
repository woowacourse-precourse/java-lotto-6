package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.LottoMachine;
import lotto.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 로또 게임을 제어하는 LottoController 객체 생성
        LottoController lottoController = new LottoController(new LottoMachine(), new InputView());

        // 구입 금액을 입력받음
        int purchaseAmount = lottoController.inputPurchaseAmount();

        // 입력된 구입 금액을 기반으로 로또 티켓을 생성
        List<Lotto> lottoTickets = lottoController.generateLottoTickets(purchaseAmount);

        // 당첨 번호를 입력받음
        List<Integer> winningNumbers = lottoController.inputWinningNumbers();

        // 보너스 볼을 입력받음
        int bonusNumber = lottoController.inputBonusNumber(winningNumbers);

        // 당첨 결과 계산
        WinningResult winningResult = lottoController.calculateWinningResult(lottoTickets, winningNumbers, bonusNumber);

        // 당첨 결과 출력
        lottoController.showResult(lottoTickets, winningResult);
    }
}
