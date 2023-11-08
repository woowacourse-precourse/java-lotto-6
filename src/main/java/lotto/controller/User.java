package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private static final int MINIMUM_MATCH_COUNT = 3;
    private final int FIRST_PLACE_MATCH_COUNT = 6;
    private final int MAXIMUM_MATCH_COUNT = 7;
    private final int RANK_STD = 8;
    private final int BUY_AMOUNT_UNIT = 1000;

    private final List<Lotto> lottos;
    private final Map<Integer, Integer> rankResult;

    public User() {
        this.lottos = new ArrayList<>();
        this.rankResult = initRankResult();
    }

    private Map<Integer, Integer> initRankResult () {
        Map<Integer, Integer> initMap = new HashMap<>();
        for (int i = Rank.FIRST.getRank(); i <= Rank.FIFTH.getRank(); i++) {
            initMap.put(i, 0);
        }
        return initMap;
    }

    public int getPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();

        if(!userInput.matches("[0-9]+")){
            System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }

        int amount = Integer.parseInt(userInput);
        if(!Validator.isThousandWonUnit(amount)){
            System.out.println("[ERROR] 1000원 단위로 구입이 가능합니다.");
            throw new IllegalArgumentException();
        }

        return amount;
    }

    public void receiveLottoNumbers(List<Lotto> lottoNumbers){
        this.lottos.addAll(lottoNumbers);
    }

    public Map<Integer, Integer> compareWithLottoResult(LottoResult lottoResult) {
        for (Lotto lotto : lottos) {
            int count = getMatchNumCount(lotto, lottoResult.getLotto().getNumbers());
            boolean isBonusNumMatch = lotto.getNumbers().contains(lottoResult.getBonusNumber());
            if (isBonusNumMatch) {
                count++;
            }
            if (count >= MINIMUM_MATCH_COUNT) {
                int rank = calculateRank(rankResult, count, isBonusNumMatch);
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
        return rankResult;
    }

    private int getMatchNumCount(Lotto lotto, List<Integer> lottoNums) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> lottoNums.contains(num))
                .count();
    }

    private int calculateRank(Map<Integer, Integer> rankResult, int count, boolean isBonusNumMatch) {
        if (count == MAXIMUM_MATCH_COUNT || count == FIRST_PLACE_MATCH_COUNT && !isBonusNumMatch) {
            return Rank.FIRST.getRank();
        }
        if (count == FIRST_PLACE_MATCH_COUNT && isBonusNumMatch) {
            return Rank.SECOND.getRank();
        }
        return RANK_STD - count;
    }

    public void printLottoResult() {
        System.out.printf(
                String.valueOf("당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - %d개\n" +
                        "4개 일치 (50,000원) - %d개\n" +
                        "5개 일치 (1,500,000원) - %d개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                        "6개 일치 (2,000,000,000원) - %d개\n")
                , rankResult.get(Rank.FIFTH.getRank())
                , rankResult.get(Rank.FOURTH.getRank())
                , rankResult.get(Rank.THIRD.getRank())
                , rankResult.get(Rank.SECOND.getRank())
                , rankResult.get(Rank.FIRST.getRank())
        );
        System.out.printf(String.valueOf("총 수익률은 %.1f%%입니다.\n"), getProfitRate());
    }

    private double getProfitRate() {
        double profit = 0;
        int buyAmount = lottos.size() * BUY_AMOUNT_UNIT;
        for (Rank rank : Rank.values()) {
            profit += rankResult.get(rank.getRank()) * rank.getPrize();
        }
        return (profit / buyAmount) * 100;
    }
}
