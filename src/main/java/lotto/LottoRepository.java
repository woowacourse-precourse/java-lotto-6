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
        calculateRank(lotto);
        lottos.add(lotto);
    }
    public void calculateRank(Lotto lotto){
        int rank = lottoRank.isRank(lotto, winningLotto, bonusNum);
        ranks[rank-1]++;
    }
}
