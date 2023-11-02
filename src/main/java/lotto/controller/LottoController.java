package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoRandomGenerator;
import lotto.model.WinningStatistics;
import lotto.utils.Parser;

public class LottoController {
    public void run() {
        // 구입 금액 입력 받기
        int budget = getBudget();

        // 구입한 금액만큼 로또 생성
        int quantity = budget / 1000;
        List<Lotto> lottoTicketsPurchased = createLottoTickets(quantity);

        // 구입한 로또 개수 출력
        OutputController.printLottoTicketsCount(lottoTicketsPurchased.size());

        // 구입한 로또 번호들 출력
        OutputController.printLottoTickets(lottoTicketsPurchased);

        // 당첨 번호 입력 받기
        Lotto winningLottoTicket = getWinningLottoTicket();

        // 보너스 번호 입력 받기
        int bonusNumber = getBonusNumber(winningLottoTicket);

        // 당첨 통계 계산
        WinningStatistics winningStatistics = new WinningStatistics(winningLottoTicket, bonusNumber,
                lottoTicketsPurchased);
        // 당첨 통계 출력
        OutputController.printWinningStatistics(winningStatistics);

        // 수익률 계산 및 출력
        double rateOfReturn = calculateRateOfReturn(budget, winningStatistics.calculateSumOfPrize());
        OutputController.printRateOfReturn(rateOfReturn);
    }

    private int getBudget() {
        return Integer.parseInt(InputController.scanBudget());
    }

    private Lotto getWinningLottoTicket() {
        // TO DO: "1,2,3,4,5,6" String으로 Lotto 객체 생성해서 반환
        String userInput = InputController.scanWinningLottoTicket();
        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        return new Lotto(lotto);
    }

    private int getBonusNumber(Lotto winningLottoTicket) {
        return Integer.parseInt(InputController.scanBonusNumber(winningLottoTicket));
    }

    private Double calculateRateOfReturn(int budget, Long earnedAmount) {
        return earnedAmount * 100 / (double) budget;
    }

    private List<Lotto> createLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(createRandomLottoTicket(new LottoRandomGenerator()));
        }
        return lottoTickets;
    }

    private Lotto createRandomLottoTicket(LottoGenerator lottoGenerator) {
        return lottoGenerator.generate();
    }
}
