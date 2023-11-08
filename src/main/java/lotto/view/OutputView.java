package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.dto.GameResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Instruction.*;

public class OutputView {
    private static final String OPENING_BRAKETS = "[";
    private static final String CLOSING_BRAKETS = "]";
    private static final String COMMA_SEPARATOR = ",";
    private static final String WINNING_STATISTICS_INSTRUCTION = "당첨 통계";
    private static final String DIVIDING_LINE = "---";

    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.getTotalLottos().size() + LOTTOS_SIZE_SUFFIX_MESSAGE.getMessage());
        lottos.getTotalLottos()
                .stream()
                .forEach(lotto -> printLotto(lotto));
        System.out.println();
    }

    private static void printLotto(final Lotto lotto) {
        System.out.print(OPENING_BRAKETS);
        int lottoTicketSize = lotto.getLottoTicket().size();
        for (int i = 0; i < lottoTicketSize - 1 ; i++) {
            System.out.print(lotto.getLottoTicket().get(i).getLottoNumber() + COMMA_SEPARATOR);
        }
        System.out.print(lotto.getLottoTicket().get(lottoTicketSize-1).getLottoNumber());
        System.out.println(CLOSING_BRAKETS);
    }

    public static void printLottoWinningResult(final GameResult gameResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_INSTRUCTION);
        System.out.println(DIVIDING_LINE);
        List<Rank> ranks = Arrays.asList(Rank.values())
                .stream()
                .filter(rank -> rank != Rank.NO_MATCH)
                .collect(Collectors.toList());
        Collections.reverse(ranks);
        ranks.stream()
                .forEach(rank -> printRankResult(rank, gameResult.getRankCount(rank)));
    }

    private static void printRankResult(final Rank rank, final int count) {
        if (rank == Rank.SECOND) {
            System.out.println(rank.getCorrectCount() + LOTTOS_BONUS_NUMBER_MATCH_MESSAGE.getMessage() + rank.getMoney() + WON_SUFFIX_MESSAGE.getMessage() + count + COUNT_SUFFIX_MESSAGE.getMessage());
            return;
        }
        System.out.println(rank.getCorrectCount() + COUNT_MATCH_SUFFIX_MESSAGE.getMessage() + rank.getMoney() + WON_SUFFIX_MESSAGE.getMessage() + count + COUNT_SUFFIX_MESSAGE.getMessage());
    }
}
