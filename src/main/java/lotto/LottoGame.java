package lotto;

import static java.lang.Integer.parseInt;
import static lotto.constants.StringConstants.BUY_FORMAT_MESSAGE;
import static lotto.constants.StringConstants.INPUT_BONUS_MESSAGE;
import static lotto.constants.StringConstants.INPUT_BUY_PRICE;
import static lotto.constants.StringConstants.INPUT_WINNING_MESSAGE;
import static lotto.constants.StringConstants.MATCH_RESULT_MESSAGE;
import static lotto.constants.StringConstants.MATCH_RESULT_PROFIT_RATE;
import static lotto.constants.StringConstants.MATCH_RESULT_WITH_BONUS_MESSAGE;
import static lotto.constants.StringConstants.WINNING_RESULT_MESSAGE;
import static lotto.constants.StringConstants.WINNING_RESULT_SEPARATOR;
import static lotto.io.Input.promptLine;
import static lotto.io.Output.printf;
import static lotto.io.Output.println;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.Game;
import lotto.game.result.GameLoopResult;
import lotto.utils.RandomUtils;

public class LottoGame implements Game {
    final int lottoPrice = 1000;
    List<Lotto> lottos = new ArrayList<>();
    List<Integer> winnings;
    int bonus;

    @Override
    public BeforeLoopResult beforeLoop() {
        int buyPrice = parseInt(promptLine(INPUT_BUY_PRICE));
        int lottoCount = buyPrice / lottoPrice;

        printf(BUY_FORMAT_MESSAGE, lottoCount);
        for (int i = 0 ; i < lottoCount ; i++) {
            var lotto = new Lotto(RandomUtils.createSortedUniqueRandomListOf(1, 45, 6));
            println(lotto.toString());
            lottos.add(lotto);
        }
        return BeforeLoopResult.GAME_READY;
    }

    @Override
    public GameLoopResult gameLoop() {
        winnings = Arrays.stream(promptLine(INPUT_WINNING_MESSAGE)
                .split(",", -1))
                .map(Integer::parseInt)
                .toList();
        if (winnings.size() != 6) {
            throw new IllegalStateException();
        }
        // TODO: 중복 처리 
        // TODO: 범위 처리
        bonus = parseInt(promptLine(INPUT_BONUS_MESSAGE));
        return GameLoopResult.END_GAME;
    }

    @Override
    public AfterLoopResult afterLoop() {
        println(WINNING_RESULT_MESSAGE);
        println(WINNING_RESULT_SEPARATOR);


        long match3 = lottos.stream()
                .filter(lotto -> lotto.matchCount(winnings) == 3)
                .count();
        long match4 = lottos.stream()
                .filter(lotto -> lotto.matchCount(winnings) == 4)
                .count();
        long match5 = lottos.stream()
                .filter(lotto -> lotto.matchCount(winnings) == 5 && !lotto.matchBonus(bonus))
                .count();
        long match5Bonus = lottos.stream()
                .filter(lotto -> lotto.matchCount(winnings) == 5 && lotto.matchBonus(bonus))
                .count();
        long match6 = lottos.stream()
                .filter(lotto -> lotto.matchCount(winnings) == 6)
                .count();

        printf(MATCH_RESULT_MESSAGE + "\n", 3, 5000, match3);
        printf(MATCH_RESULT_MESSAGE + "\n", 4, 50000, match4);
        printf(MATCH_RESULT_MESSAGE + "\n", 5, 1500000, match5);
        printf(MATCH_RESULT_WITH_BONUS_MESSAGE + "\n", 5, 30000000, match5Bonus);
        printf(MATCH_RESULT_MESSAGE + "\n", 6, 2000000000, match6);

        var profit = 5000L * match3 +
                50000L * match4 +
                1500000L * match5 +
                30000000L * match5Bonus +
                2000000000L * match6;

        var profitRate = ((double)profit / (lottoPrice * lottos.size())) * 100;
        printf(MATCH_RESULT_PROFIT_RATE, profitRate);
        return AfterLoopResult.END_GAME;
    }
}
