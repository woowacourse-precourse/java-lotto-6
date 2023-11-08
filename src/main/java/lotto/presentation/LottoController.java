package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.application.LottoService;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;
import lotto.domain.RewardConfiguration;
import lotto.domain.Ticket;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    private void printOneTicket(Ticket ticket) {
        List<String> numberTexts = ticket.getNumbers().stream()
                .map(String::valueOf)
                .toList();
        String ticketText = String.join(", ", numberTexts);
        System.out.println("[" + ticketText + "]");
    }

    private void printTickets(List<Ticket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        tickets.forEach(this::printOneTicket);
        System.out.println();
    }

    private void askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyText = Console.readLine();
        try {
            List<Ticket> tickets = lottoService.buyLotto(moneyText);
            printTickets(tickets);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askMoney();
        }
    }

    private void askDrawResults() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbersText = Console.readLine();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusText = Console.readLine();
        System.out.println();
        try {
            lottoService.setDrawResult(numbersText, bonusText);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askDrawResults();
        }
    }

    private void printOneStatisticEntry(LottoResult lottoResult, Long count) {
        System.out.println(RewardConfiguration.getReward(lottoResult) + "원 - " + count + "개");
    }
    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        LottoStatistic lottoStatistic = lottoService.getLottoStatistic();
    }

    public void run() {
        askMoney();

        askDrawResults();

        printResult();
    }
}
