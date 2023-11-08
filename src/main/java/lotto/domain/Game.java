package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.exception.NumberTypeFormatException;
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
        Map<Prize, Integer> result = compare(lottoTicket);
        end(result, money);
    }

    private Money getMoney() {
        outputView.print(PrintMessage.INPUT_MONEY);
        Integer input = null;
        try {
            input = inputView.readNumber();
        } catch (NumberTypeFormatException e) {
            outputView.print(e.getMessage());
            getMoney();
        }
        Money money = new Money(input);
        outputView.print(PrintMessage.EMPTY);

        return money;
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

    private Map<Prize, Integer> compare(LottoTicket lottoTicket) {
        AnswerLottos answerLottos = getAnswerLottos();
        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(answerLottos);
        return winningAnalyzer.compare(lottoTicket);
    }

    private AnswerLottos getAnswerLottos() {
        outputView.print(PrintMessage.INPUT_ANSWER_LOTTO);
        List<Integer> input = null;
        try {
            input = inputView.readNumbers();
        } catch (NumberFormatException e) {
            outputView.print(e.getMessage());
            getAnswerLottos();
        }

        Lotto lotto = new Lotto(input);
        outputView.print(PrintMessage.EMPTY);

        return new AnswerLottos(lotto, getBonusBall());
    }

    private BonusBall getBonusBall() {
        outputView.print(PrintMessage.INPUT_BONUS_LOTTO);
        Integer input = null;
        try {
            input = inputView.readNumber();
        } catch (NumberTypeFormatException e) {
            outputView.print(e.getMessage());
            getBonusBall();
        }
        outputView.print(PrintMessage.EMPTY);
        return new BonusBall(input);
    }

    private void end(Map<Prize, Integer> prizeResult, Money money) {
        outputView.print(PrintMessage.WINNING_STATISTICS);
        outputView.print(PrintMessage.WINNING_STATISTICS_HEADER);

        printStatistics(prizeResult);
        Statistics statistics = new Statistics(prizeResult);
        outputView.print(PrintMessage.RATE_FORMAT, statistics.calculate(money.getMoney()));
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
