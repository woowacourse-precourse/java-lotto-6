package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.util.Computer;
import lotto.util.Counter;
import lotto.util.Generator;
import lotto.util.Matcher;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public static void start() {
        // 구입 금액
        int ticketAmount = InputView.requestPurchaseAmount();

        // 자동 번호 생성
        List<Lotto> tickets = Generator.publishTickets(ticketAmount);
        OutputView.responseTickets(ticketAmount, tickets);

        // 당첨 번호
        Lotto winnigLotto = InputView.requestWinningNumbers();

        // 보너스 번호
        int bonusLotto = InputView.requestBonusNumber(winnigLotto);

        // 로또 번호 추첨
        List<Result> results = Matcher.matchResult(tickets, winnigLotto, bonusLotto);

        // 당첨된 등수 계산
        Rank rank = Counter.countRank(results);

        // 수익률 계산
        BigDecimal profit = Computer.computeProfit(ticketAmount, rank);

        // 당첨 통계 발표
        OutputView.responseWinningStatics(rank, profit);

        Console.close();
    }
}
