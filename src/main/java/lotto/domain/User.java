package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.GenerateLottoNumbers.generateLottoNumbers;

// 로또 구매 및 저장, 구매 금액과 총 상금 관리
public class User {
    private int buyingPrice;
    private int winningPrice;
    private List<UserLotto> lottos;

    public User(int buyingPrice) {
        lottos = new ArrayList<>();
        this.buyingPrice = buyingPrice;
        this.winningPrice = 0;
    }

    public void setLottos(int buyingPrice) {
        this.lottos = generateLottoNumbers(buyingPrice);
    }

    public List<UserLotto> getLottos() {
        return lottos;
    }

    public int getBuyingPrice(){
        return buyingPrice;
    }
    public int getWinningPrice(){
        return winningPrice;
    }
    public void addWinningPrice(int money){
        winningPrice += money;
    }
}
