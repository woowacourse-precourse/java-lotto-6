package lotto;

import static java.lang.Integer.parseInt;
import static lotto.constants.IntegerConstants.LOTTO_NUMBERS_COUNT;
import static lotto.constants.IntegerConstants.LOTTO_PRICE;
import static lotto.constants.IntegerConstants.LOTTO_RANGE_END;
import static lotto.constants.IntegerConstants.LOTTO_RANGE_START;
import static lotto.constants.IntegerConstants.MATCH_FIVE_BONUS_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FIVE_REWARD;
import static lotto.constants.IntegerConstants.MATCH_FOUR_REWARD;
import static lotto.constants.IntegerConstants.MATCH_SIX_REWARD;
import static lotto.constants.IntegerConstants.MATCH_THREE_REWARD;
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
import java.util.List;
import lotto.exceptions.InvalidNumberRangeException;
import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.Game;
import lotto.io.Input;
import lotto.utils.RandomUtils;

public class LottoGame implements Game {
    LottoMatcher matcher;

    @Override
    public BeforeLoopResult beforeLoop()  {
        int buyPrice = parseInt(promptLine(INPUT_BUY_PRICE));
        if (buyPrice % LOTTO_PRICE != 0) {
            throw new InvalidNumberRangeException();
        }
        int lottoCount = buyPrice / LOTTO_PRICE;
        printf(BUY_FORMAT_MESSAGE, lottoCount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0 ; i < lottoCount ; i++) {
            var lotto = new Lotto(RandomUtils.createSortedUniqueRandomListOf(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBERS_COUNT));
            println(lotto.toString());
            lottos.add(lotto);
        }

        matcher = new LottoMatcher(lottos);
        return BeforeLoopResult.GAME_READY;
    }


    @Override
    public AfterLoopResult afterLoop() {
        println(INPUT_WINNING_MESSAGE);
        var winnings = Input.readLineAsIntegerList(",");

        if (winnings.size() != 6) {
            throw new IllegalStateException();
        }
        // TODO: 중복 처리
        // TODO: 범위 처리
        var bonus = parseInt(promptLine(INPUT_BONUS_MESSAGE));

        println(WINNING_RESULT_MESSAGE);
        println(WINNING_RESULT_SEPARATOR);


        GroupedLottoMatchResult matchResults = matcher.matchAll(winnings, bonus);

        printf(MATCH_RESULT_MESSAGE + "\n", 3, MATCH_THREE_REWARD, matchResults.countMatchResult(LottoMatchResult.MATCH_THREE));
        printf(MATCH_RESULT_MESSAGE + "\n", 4, MATCH_FOUR_REWARD, matchResults.countMatchResult(LottoMatchResult.MATCH_FOUR));
        printf(MATCH_RESULT_MESSAGE + "\n", 5, MATCH_FIVE_REWARD, matchResults.countMatchResult(LottoMatchResult.MATCH_FIVE));
        printf(MATCH_RESULT_WITH_BONUS_MESSAGE + "\n", 5, MATCH_FIVE_BONUS_REWARD, matchResults.countMatchResult(LottoMatchResult.MATCH_FIVE_BONUS));
        printf(MATCH_RESULT_MESSAGE + "\n", 6, MATCH_SIX_REWARD, matchResults.countMatchResult(LottoMatchResult.MATCH_SIX));

        printf(MATCH_RESULT_PROFIT_RATE, matchResults.getProfitRate());
        return AfterLoopResult.END_GAME;
    }
}
