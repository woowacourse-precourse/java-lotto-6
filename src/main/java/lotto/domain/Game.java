package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public Game(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Money money = getMoney();
        LottoTicket lottoTicket = generateLottoTicket(money);
        Results results = compare(lottoTicket);
        end(results, money);
    }

    private LottoTicket generateLottoTicket(Money money) {
        LottoTicket buyLottoTicket = lottoMachine.buy(money, new AutoLottoGenerator());
        List<Lotto> lottos = buyLottoTicket.getLottos();

        outputView.print(PrintMessage.BUY_AMOUNT_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            outputView.print(lotto.toString());
        }
        outputView.print(PrintMessage.EMPTY);

        return buyLottoTicket;
    }

    private Money getMoney() {
        outputView.print(PrintMessage.INPUT_MONEY);
        Money money = new Money(inputView.readNumber());
        outputView.print(PrintMessage.EMPTY);

        return money;
    }

    private Results compare(LottoTicket lottoTicket) {
        AnswerLottos answerLottos = getAnswerLottos();
        List<Result> result = answerLottos.match(lottoTicket);
        return new Results(result);
    }

    private AnswerLottos getAnswerLottos() {
        outputView.print(PrintMessage.INPUT_ANSWER_LOTTO);
        Lotto lotto = new Lotto(inputView.readNumbers());
        outputView.print(PrintMessage.EMPTY);

        outputView.print(PrintMessage.INPUT_BONUS_LOTTO);
        BonusBall bonusBall = new BonusBall(inputView.readNumber());
        outputView.print(PrintMessage.EMPTY);

        return new AnswerLottos(lotto, bonusBall);
    }

    private void end(Results results, Money money) {
        Map<Prize, Integer> prizeResult = results.getPrizeResult();
        outputView.print(PrintMessage.WINNING_STATISTICS);
        outputView.print(PrintMessage.WINNING_STATISTICS_HEADER);

        printStatistics(prizeResult);
        outputView.print(PrintMessage.RATE_FORMAT, calculate(prizeResult, money.getMoney()));
    }

    private double calculate(Map<Prize, Integer> prizeResults, int money) {
        return sum(prizeResults) * 0.1 / money;
    }

    private double sum(Map<Prize, Integer> prizeResults) {
        return prizeResults.entrySet()
                .stream()
                .mapToDouble(prizeResult -> prizeResult.getKey().getReward() * prizeResult.getValue())
                .sum();
    }

    private void printStatistics(Map<Prize, Integer> prizeResult) {
        Set<Entry<Prize, Integer>> prizes = prizeResult.entrySet();

        for (Entry<Prize, Integer> prize : prizes) {
            Prize key = prize.getKey();
            if (key.equals(Prize.SECOND)) {
                outputView.print(PrintMessage.WINNING_BONUS_FORMAT, key.getMatchCount(), key.getReward(),
                        prize.getValue());
            }
            if (!key.equals(Prize.NONE)) {
                outputView.print(PrintMessage.WINNING_FORMAT, key.getMatchCount(), key.getReward(), prize.getValue());
            }
        }
    }
}
