package lotto.domain;

import static lotto.consts.ConstsString.INITIAL_MATCH_COUNT;
import static lotto.consts.ConstsString.ZERO;
import static lotto.consts.ConstsString.ONE;

import java.util.LinkedHashMap;
import java.util.List;

public class WinningCalculator {
    private final BonusNumber bonusNumber;
    private final Lotto winningLotto;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LinkedHashMap<LottoRank, Integer> winnerCount;

    public WinningCalculator(LottoNumberGenerator lottoNumberGenerator, Lotto winningLotto, BonusNumber bonusNumber) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.winnerCount = initializeWinningCount();
    }

    private LinkedHashMap<LottoRank, Integer> initializeWinningCount(){
        LinkedHashMap<LottoRank, Integer> lottoMap = new LinkedHashMap<>();
        for(LottoRank rank : LottoRank.values()){
            lottoMap.put(rank,INITIAL_MATCH_COUNT);
        }
        return lottoMap;
    }

    public LinkedHashMap<LottoRank, Integer> calculate() {
        List<Lotto> tickets = lottoNumberGenerator.getLottoNumbers();

        for (Lotto ticket : tickets) {
            int matchCount = getMatchPoint(ticket.getNumbers(), winningLotto.getNumbers());
            boolean matchBonus = checkMatchBonus(ticket);
            updateWinnerCount(matchCount, matchBonus);
        }
        return winnerCount;
    }

    private void updateWinnerCount(int matchCount, boolean matchBonus) {
        LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
        winnerCount.put(rank, winnerCount.get(rank) + ONE);
    }

    private boolean checkMatchBonus(Lotto lottoList){
        return lottoList.getNumbers().contains(bonusNumber.getBonus());
    }

    private int getMatchPoint(List<Integer> lottoNumbers, List<Integer> winninNumbers){
        int count = ZERO;
        for(int number : lottoNumbers){
            if(winninNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    public LinkedHashMap<LottoRank, Integer> getWinnerCount(){
        return this.winnerCount;
    }
}
