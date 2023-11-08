package lotto;

import java.util.List;

public class CompareLotto {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private int[] ranking = new int[]{0, 0, 0, 0, 0, 0};
    CompareLotto(List<Integer> winningNumber, int bonusNumber){
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    void compare(List<List<Integer>> userLotto){
        for(int i = 0; i < userLotto.size(); i++){
            int cnt = oneRound(userLotto.get(i));
            findRank(cnt, userLotto.get(i));
        }
    }

    private int oneRound(List<Integer> boughtNumber){
        int cnt = 0;
        for(int i = 0; i < 6; i++){
            if(boughtNumber.contains(winningNumber.get(i))){
                cnt++;
            }
        }
        return cnt;
    }

    private void findRank(int cnt, List<Integer> boughtNumber){
        if(cnt == 6) ranking[1] += 1;
        else if(cnt == 5 && boughtNumber.contains(bonusNumber)) ranking[2] += 1;
        else if(cnt == 5) ranking[3] += 1;
        else if(cnt == 4) ranking[4] += 1;
        else if(cnt == 3) ranking[5] += 1;
    }

    public int[] getRanking(){
        return this.ranking;
    }

}
