package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoRepository {
    private List<Lotto> lottos;
    private LottoRank lottoRank;
    private int[] ranks=new int[6];
    private final Lotto winningLotto;
    private final int bonusNum;
    public LottoRepository(Lotto winningLotto,int bonusNum){
        this.winningLotto=winningLotto;
        this.bonusNum=bonusNum;
        Arrays.fill(ranks,0);
    }
    public void addLotto(Lotto lotto){
        if(calculateRank(lotto))
            return;
        lottos.add(lotto);
    }
    private boolean calculateRank(Lotto lotto){
        int rank = lottoRank.isRank(lotto, winningLotto, bonusNum);
        if(rank==-1){
            System.out.println("[ERROR] 로또의 번호 개수는 6개여야 합니다.");
            return false;
        }
        ranks[rank-1]++;
        return true;
    }

    public int[] getRanks() {
        return ranks;
    }
}
