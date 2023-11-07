package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;
import lotto.view.Input;
import lotto.view.Output;
import lotto.view.PrizeResult;

import java.util.List;

public class Game {

    private final Input input = Input.getInstance();
    private final Output output = Output.getInstance();

    private LottoRepository repository;

    public Game() {
        this.repository = new LottoRepository();
    }

    public void run() {
        init();
        draw();
        prize();
    }

    private void init() {
        // 구입금액 입력
        output.printPurchaseAmountMessage();
        int count = repository.buyTicket(input.inputPurchaseAmount());
        output.printLineBreak();

        // 구매 결과 출력
        output.printBuyingMessage(count);
        output.printLottoTickets(repository.getMyTickets());
        output.printLineBreak();
    }

    private void draw() {
        // 당첨 번호 입력
        output.printWinningNumbersMessage();
        Lotto lotto = new Lotto(input.inputNumbers());
        output.printLineBreak();

        // 보너스 번호 입력
        output.printBonusNumberMessage();
        int number = input.inputBonusNumber();
        output.printLineBreak();

        repository.drawLotto(lotto, number);
    }

    private void prize() {
        output.printWinningStatisticsMessage();
        int[] result = repository.confirmTickets();
        output.printWinningStatistics(result);
        output.printRateOfReturns(calculate(result));
    }


    /**
     * 수익률을 계산하는 함수
     *
     * @param result 당첨된 로또의 개수를 담은 int[] 형 변수
     * @return 수익률을 반환한다.
     */
    public double calculate(int[] result) {
        int sum = 0;
        for (PrizeResult ps : PrizeResult.values()) {
            if (ps == PrizeResult.FIVE_BONUS) {
                sum += result[result.length - 1] * ps.getMoney();
                continue;
            }
            sum += result[ps.getSame()] * ps.getMoney();
        }
        double rate = (double) sum / repository.getPurchaseAmount() * 100;
        rate = Math.round(rate * 10) / 10.0;
        return rate;
    }


}
