package lotto.service;


import lotto.Domain.Lotto;
import lotto.Domain.LottoGrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Match {

    private Map<LottoGrade,Integer> lottoResult;                //등수, 개수
    public void lottoResult(List<Lotto> lottoPlayList, Lotto winNumber, int bonus){
        for(Lotto lotto : lottoPlayList){

            int matchNumber = getMatchNumber(lotto,winNumber);
            boolean matchBonus = false;
            if(matchNumber == 5){
                matchBonus = getMatchBonus(lotto,bonus);
            }
            LottoGrade lottoGrade = LottoGrade.getLottoGrade(matchNumber,matchBonus);
            lottoResult.put(lottoGrade,lottoResult.getOrDefault(lottoGrade,0)+1);       //몇등이 몇개인가
        }
    }
    public Map<LottoGrade, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getMatchNumber(Lotto lotto ,Lotto winLotto){
        int count=0;
        for(int i : winLotto.getNumbers()) {
            if (lotto.getNumbers().contains(i)){
                count++;
               //번호 맞는만큼 카운트해서 반환
            }
        }
        return count;
    }

    public boolean getMatchBonus(Lotto lotto,int bonus) {
        return lotto.getNumbers().contains(bonus);              //보너스 맞으면 true
    }
    public Match() {
        initMatch();
    }
    private void initMatch() {
        lottoResult = new HashMap<>();
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            lottoResult.put(lottoGrade, 0);
        }
    }

    public long sumPrize(){
        long sum = 0;
        for(LottoGrade lottoGrade : lottoResult.keySet()){
            int grade = lottoResult.get(lottoGrade);
            sum += lottoGrade.getMoney()*grade;
        }
        return sum;
    }

    public double rate(long sumPrize ,long money){
        return ((double) sumPrize / money) * 100;
    }

}
