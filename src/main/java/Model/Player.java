package Model;

import Config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Money money;
    private final List<Lotto> lottoBundle = new ArrayList<>();
    private Winning winning;
    private Bonus bonus;
    private int winningMoney;

    public Player(Money money){
        this.money = money;
    }

    public void buyLotto(){
        int lottoNumber = money.getLottoNumber();
        for (int trial = 0; trial < lottoNumber; trial++){
            lottoBundle.add(new Lotto(Randoms.pickUniqueNumbersInRange(GameConfig.MIN_LOTTO, GameConfig.MAX_LOTTO, GameConfig.LOTTO_NUMBER)));
        }
    }

    public List<String> checkLotto(){
        List<String> LottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottoBundle){
            LottoNumbers.add(lotto.getLotto());
        }
        return LottoNumbers;
    }

    public void announceWinning(Winning winning, Bonus bonus){
        this.winning = winning;
        this.bonus = bonus;
        this.winningMoney = 0;
    }

    public void checkWinning(){
        for (Lotto lotto : lottoBundle){
            int rank = lotto.getResult(winning, bonus);
            winningMoney += GameConfig.WINNING.valueOfRank(rank).getPrice();
        }
    }

    public String calculateYield(){
        return money.getYield(winningMoney);
    }

}
