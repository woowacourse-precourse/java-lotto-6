package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoRepository {
    private List<Lotto> lottos=new ArrayList<>();
    private int[] ranks = new int[6];
    private Lotto winningLotto;
    private int bonusNum=-1;
    private final int[] PRIZE = {20000000, 3000000, 1500000, 50000, 5000};
    private static final String RANK_ERROR_MESSAGE = "[ERROR] 로또의 번호 개수는 6개여야 합니다.";

    public boolean setWinningLotto(Lotto lotto) {
        if(bonusNum==-1){
            this.winningLotto=lotto;
            return true;
        }
        else {
            if (lotto.getNumbers().stream().anyMatch(number -> number == bonusNum)) {
                System.out.println("[ERROR] 당첨 로또 번호와 보너스 번호 중 중복되는 것이 있습니다.");
                return false;
            } else {
                this.winningLotto = lotto;
                return true;
            }
        }
    }

    public boolean setBonusNum(int bonusNum) {
        if(winningLotto == null) {
            this.bonusNum = bonusNum;
            return true;
        }
        else {
            if (winningLotto.getNumbers().stream().anyMatch(number -> number == bonusNum)) {
                System.out.println("[ERROR] 보너스 번호가 당첨 로또 번호와 중복되는 것이 있습니다.");
                return false;
            } else {
                this.bonusNum = bonusNum;
                return true;
            }
        }
    }

    public int[] getRanks() {
        Arrays.fill(ranks, 0);
        for (Lotto lotto : lottos) {
            calculateRank(lotto);
        }
        return ranks;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void addLotto(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    private boolean calculateRank(Lotto lotto) {
        int rank = LottoRank.isRank(lotto, winningLotto, bonusNum);
        if (rank == -1) {
            System.out.println(RANK_ERROR_MESSAGE);
            return false;
        }
        ranks[rank - 1]++;
        return true;
    }


    public double getProfitRate() {
        int money = lottos.size() * 1000;
        int prize = 0;
        for (int i = 0; i < 5; i++) {
            prize = prize + ranks[i] * PRIZE[i];
        }
        double rate = Math.round((double) prize * 1000 / money) / 1000.0;
        return rate;
    }

}
