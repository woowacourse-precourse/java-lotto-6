package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.MatchResult;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.constant.NumberConstant.*;
import static lotto.service.InputService.readExpense;

public class ComputeService {
    public static int computeLottoTicketNum() {
        return (int) (readExpense() / LOTTO_PRICE);
    }


    public static Map<MatchResult, Integer> computeResult(List<Lotto> randomLottos, Lotto winningLotto, int bonusNum) {
        Map<MatchResult, Integer> result = initEnumMap();

        for (Lotto randomLotto : randomLottos) {
            MatchResult matchResult = Lotto.match(randomLotto, winningLotto, bonusNum);

            result.compute(matchResult, (k, v) -> v + MATCHRESULT_INCREMENT);
        }

        return result;
    }

    private static Map<MatchResult, Integer> initEnumMap() {
        EnumMap<MatchResult, Integer> enumMap = new EnumMap<>(MatchResult.class);

        for (MatchResult matchResult : MatchResult.values())
            enumMap.put(matchResult, MATCHRESULT_INIT_NUM);

        return enumMap;
    }


    public static double computeMargin(Map<MatchResult, Integer> result, int lottoTicketNum) {
        long totalPrize = computeTotalPrize(result);
        long expense = computeExpense(lottoTicketNum);
        double margin = (double) totalPrize / expense * PERCENT_MULTIPLIER;

        return computeDecimalPoint(margin);
    }

    private static long computeTotalPrize(Map<MatchResult, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(match -> computePrizeByNum(match.getKey(), match.getValue()))
                .sum();
    }

    private static long computePrizeByNum(MatchResult matchResult, int num) {
        return matchResult.getPrizeMoney() * num;
    }

    private static long computeExpense(int lottoTicketNum) {
        return ((long) lottoTicketNum) * LOTTO_PRICE;
    }

    private static double computeDecimalPoint(double margin) {
        return Math.round(margin * DECIMAL_POINT_MULTIPLIER) / DECIMAL_POINT_DENOMINATOR;
    }
}
