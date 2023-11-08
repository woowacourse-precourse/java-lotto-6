package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import lotto.constant.ValidatorMessage;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Order;
import lotto.model.WinStatistics;
import lotto.util.SplitGenerator;
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
        try {
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
        } finally {
            Console.close();
        }
    }

    private void inputCost() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                this.order = new Order(inputView.inputCost());

                isValidInput = true;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (IllegalStateException exception) {
                System.out.println(ValidatorMessage.INVALID_INPUT_COST);
            }
        }
    }

    private void createLottoTicket() {
        this.lottoTicket = this.order.buy();
    }

    private void printLottoTicket() {
        outputView.buyLottoNumbers(this.lottoTicket, this.order);
    }

    private void inputWiningLotto() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                String lottoNumbers = inputView.inputLotto();

                this.winingLotto = new SplitGenerator(lottoNumbers).getLotto();

                isValidInput = true;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (IllegalStateException exception) {
                System.out.println(ValidatorMessage.INVALID_INPUT_WIN_LOTTO_NUMBER);
            }
        }
    }

    private void inputBonus() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                String tempBonus = inputView.inputBonus();

                this.bonus = new Bonus(tempBonus, this.winingLotto);

                isValidInput = true;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (IllegalStateException exception) {
                System.out.println(ValidatorMessage.INVALID_INPUT_BONUS_NUMBER);
            }
        }
    }

    private void printWinStatistics() {
        this.winStatistics = lottoTicket.getRank(winingLotto, bonus);

        outputView.winStatistics(this.winStatistics);
        outputView.printProfitRate(this.order, this.winStatistics);
    }
}
