package lotto.model;
import java.util.List;

public class LottoGame {
    private int purchasePrice;
    private int buyingLottoCount;

    private List<Lotto> purchaseLotto;
    private Lotto winningLotto;
    private int bonusNumber;

    //각 구매한 한게임 마다 결과
    private List<ResultEachLotto> matchCounts;
    //각 랭크 마다 개수
    private List<Integer> ranks;

    private int totalPrize;

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getBuyingLottoCount() {
        return buyingLottoCount;
    }

    public void setBuyingLottoCount(int buyingLottoCount) {
        this.buyingLottoCount = buyingLottoCount;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }

    public void setPurchaseLotto(List<Lotto> purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<ResultEachLotto> getMatchCounts() {
        return matchCounts;
    }

    public void setMatchCounts(List<ResultEachLotto> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public List<Integer> getRanks() {
        return ranks;
    }

    public void setRanks(List<Integer> ranks) {
        this.ranks = ranks;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }
}


