package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.parser.Parser;
import lotto.util.Counter;
import lotto.util.Generator;
import lotto.util.Matcher;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public static void start() {
        // 예외 발생해도 해당 부분에서 다시 시작하기 위해 try-catch 문 추가 예정
        // 구입금액
        String purchaseAmount = InputView.requestPurchaseAmount();
        int ticketAmount = Parser.parsePurchaseAmount(purchaseAmount);
        List<Lotto> tickets = Generator.publishTickets(ticketAmount);
        OutputView.responseTickets(ticketAmount, tickets);

        // 당첨 번호
        String winningNumbers = InputView.requestWinningNumbers();
        Lotto winnigLotto = Parser.parseWinningNumbers(winningNumbers);

        // 보너스 번호
        String bonusNumber = InputView.requestBonusNumber();
        int bonusLotto = Parser.parseBonusNumber(bonusNumber, winnigLotto);

        // 로또 번호 맞추기
        List<Result> results = Matcher.matchResult(tickets, winnigLotto, bonusLotto);

        // 당첨된 등수 세기
        Rank rank = Counter.countRank(results);

        // 당첨 통계 발표
        OutputView.responseWinningStatics(rank);
    }
}
