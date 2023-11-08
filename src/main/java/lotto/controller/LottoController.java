package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Order;
import lotto.model.WinStatistics;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private Bonus bonus;
    private Lotto winingLotto;
    private LottoTicket lottoTicket;
    private Order order;
    private WinStatistics winStatistics;

    private final Input inputView;
    private final Output outputView;

    public LottoController() {
        this.inputView = new Input();
        this.outputView = new Output();
    }

    public void runGame() {
        // 구입금액 입력
        inputCost();

        // 구입금액에 맞게 로또티켓 발행
        createLottoTicket();

        // 구매한 로또티켓 출력
        printLottoTicket();

        // 당첨 번호 입력
        inputWiningLotto();

        // 보너스 번호 입력
        inputBonus();

        // 당첨 통계 출력
        printWinStatistics();
    }

    private void inputCost() {
        try {
            this.order = new Order(inputView.inputCost());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void createLottoTicket() {

    }

    private void printLottoTicket() {

    }

    private void inputWiningLotto() {

    }

    private void inputBonus() {

    }

    private void printWinStatistics() {

    }
}
