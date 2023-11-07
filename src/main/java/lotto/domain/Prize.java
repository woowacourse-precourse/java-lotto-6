package lotto.domain;

import lotto.util.Utils;

import java.util.*;

public class Prize {
    int SECOND_CORRECT_COUNT = 5;
    private List<Integer> prizeNumber;
    private int bonusNumber;
    private final HashMap<Rank, Integer> RankCounts = new HashMap<>();


    public Prize(String prizeNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.prizeNumber = makePrizeNumbers(prizeNumber);
        initRanks();
    }

    public List<Integer> makePrizeNumbers(String prizeNumber){
        List<String> numbers = List.of(prizeNumber.split(","));
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : numbers){
            prizeNumbers.add(Utils.ChangeStringToInt(number));
        }
        return prizeNumbers;
    }

    public HashMap<Rank, Integer> makePrizeRanks(Buyer buyer) {
        List<Lotto> Lotteries = buyer.getLotteries();
        for (int i = 0; i < Lotteries.size(); i++){
            Rank rank = getRankObject(Lotteries.get(i));
            RankCounts.put(rank, RankCounts.getOrDefault(rank,0)+1);
        }
        return RankCounts;
    }

    public Rank getRankObject(Lotto lotto){
        List<Integer> compareNumbers = new ArrayList<>(prizeNumber);
        compareNumbers.retainAll(lotto.numbers);
        if (compareNumbers.size() == SECOND_CORRECT_COUNT && isContainBonusNumber(lotto.numbers) ){
            return Rank.SECOND_BONUS;
        }
        return Rank.getRankByCount(compareNumbers.size());
    }

    public boolean isContainBonusNumber(List<Integer> lottoNumbers){

        for (int number : lottoNumbers){
            if (bonusNumber == number){
                return true;
            }
        }

        return false;
    }

    private void initRanks() {
        RankCounts.put(Rank.FIRST,0);
        RankCounts.put(Rank.SECOND,0);
        RankCounts.put(Rank.SECOND_BONUS,0);
        RankCounts.put(Rank.THIRD,0);
        RankCounts.put(Rank.FOURTH,0);

    }



}
