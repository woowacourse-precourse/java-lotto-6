package lotto.domain;

import lotto.view.OutputView;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.config.LottoConfig.LOTTO_ALL_MATCH;
import static lotto.config.LottoConfig.LOTTO_ALL_MATCH_PRIZE;
import static lotto.config.LottoConfig.LOTTO_BONUS_MATCH_PRIZE;
import static lotto.config.LottoConfig.LOTTO_FIVE_MATCH_PRIZE;
import static lotto.config.LottoConfig.LOTTO_FIVE_OR_BONUS_MATCH;
import static lotto.config.LottoConfig.LOTTO_FOUR_MATCH;
import static lotto.config.LottoConfig.LOTTO_FOUR_MATCH_PRIZE;
import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.LottoConfig.LOTTO_THREE_MATCH;
import static lotto.config.LottoConfig.LOTTO_THREE_MATCH_PRIZE;


public class LottoResult {

    private final List<Lotto> lottoTickets;
    private final List<Integer> winnerNumber;
    private final int bonusNumber;
    private final int lottoAmount;
    private final LottoPrize lottoPrize = new LottoPrize();

    public LottoResult(List<Lotto> lottoTickets, List<Integer> winnerNumber, int bonusNumber, int lottoAmount) {
        this.lottoTickets = lottoTickets;
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
        this.lottoAmount = lottoAmount;
    }

    public void LottoPrizeResult() {
        lottoMatchCount();
        Double profit = lottoProfit();
        lottoPrizePrint(profit);
    }

    private void lottoMatchCount() {
        for (Lotto lotto : lottoTickets) {
            List<Integer> lottoNumber = lotto.getLottoNumber();
            lottoMatchCompare(lottoNumber);
        }
    }

    private void lottoMatchCompare(List<Integer> lottoNumber) {

        int matchNumber = lottoMatchNumber(lottoNumber);

        if (matchNumber == LOTTO_THREE_MATCH.getValue()) {
            lottoPrize.addThreeMatch();
        }
        if (matchNumber == LOTTO_FOUR_MATCH.getValue()) {
            lottoPrize.addFourMatch();
        }
        if (matchNumber == LOTTO_FIVE_OR_BONUS_MATCH.getValue()) {
            lottoBonusMatch(lottoNumber);
        }
        if (matchNumber == LOTTO_ALL_MATCH.getValue()) {
            lottoPrize.addAllMatch();
        }
    }

    private void lottoBonusMatch(List<Integer> lottoNumber) {

        boolean hasBonusCheck = lottoNumber.contains(bonusNumber);

        if (hasBonusCheck) {
            lottoPrize.addBonusMatch();
        }
        if (!hasBonusCheck) {
            lottoPrize.addFiveMatch();
        }

    }

    private int lottoMatchNumber(List<Integer> lottoNumber) {
        return lottoNumber.stream().filter(o -> winnerNumber.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList()).size();
    }

    private Double lottoProfit() {

        int totalPrize = LOTTO_THREE_MATCH_PRIZE.getValue() * lottoPrize.getThreeMatch()
                + LOTTO_FOUR_MATCH_PRIZE.getValue() * lottoPrize.getFourMatch()
                + LOTTO_FIVE_MATCH_PRIZE.getValue() * lottoPrize.getFiveMatch()
                + LOTTO_BONUS_MATCH_PRIZE.getValue() * lottoPrize.getBonusMatch()
                + LOTTO_ALL_MATCH_PRIZE.getValue() * lottoPrize.getAllMatch();

        double profit = (double) totalPrize / (lottoAmount * LOTTO_PRICE.getValue()) * 100;

        return profit;

    }

    private void lottoPrizePrint(Double profit) {

        OutputView.lottoWinningResultOutputMessage(LOTTO_THREE_MATCH.getValue()
                , LOTTO_THREE_MATCH_PRIZE.getValue(), lottoPrize.getThreeMatch());
        OutputView.lottoWinningResultOutputMessage(LOTTO_FOUR_MATCH.getValue()
                , LOTTO_FOUR_MATCH_PRIZE.getValue(), lottoPrize.getFourMatch());
        OutputView.lottoWinningResultOutputMessage(LOTTO_FIVE_OR_BONUS_MATCH.getValue()
                , LOTTO_FIVE_MATCH_PRIZE.getValue(), lottoPrize.getFiveMatch());
        OutputView.lottoWinningResultBonusOutputMessage(LOTTO_FIVE_OR_BONUS_MATCH.getValue()
                , LOTTO_BONUS_MATCH_PRIZE.getValue(), lottoPrize.getBonusMatch());
        OutputView.lottoWinningResultOutputMessage(LOTTO_ALL_MATCH.getValue()
                , LOTTO_ALL_MATCH_PRIZE.getValue(), lottoPrize.getAllMatch());
        OutputView.lottoTotalProfitMessage(profit);

    }

}
