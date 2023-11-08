package lotto;

import java.util.List;

public class LottoResult {
    private int sameCount;
    private boolean bonusMatch;

    private Rank rank;

    LottoResult(List<Integer> lotto,List<Integer> answers){
        sameCount=0;
        bonusMatch =false;
        compareLotto(lotto,answers);
        setRank();
    }
    private void compareLotto(List<Integer> lotto,List<Integer> answers){
        lotto.stream().filter(e->answers.contains(e)).forEach(l->sameCount++);
        if(checkBonus(lotto,answers))bonusMatch=true;
    }
    private boolean checkBonus(List<Integer> lotto,List<Integer> answers){
        return lotto.contains(answers.get(answers.size()-1));
    }
    private void setRank() {//랭크 부여
        if (sameCount == 6) rank= Rank.FIRST;
        if (sameCount == 5 && bonusMatch) rank= Rank.SECOND;
        if (sameCount == 5)  rank= Rank.THIRD;
        if (sameCount == 4)  rank=Rank.FOURTH;
        if (sameCount == 3)  rank= Rank.FIFTH;
        if (sameCount < 3) rank= null;
    }
    public Rank getRank(){
        return rank;
    }
    public int getSameCount() {
        return sameCount;
    }
    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
