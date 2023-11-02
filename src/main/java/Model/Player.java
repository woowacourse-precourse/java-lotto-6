package Model;

import Config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Money money;
    private final List<Lotto> lottoBundle = new ArrayList<>();
    private final Winning winning;
    private final Bonus bonus;
    private int winningMoney;

    Player(String money, String winning, String bonus){
        this.money = new Money(money);
        this.winning = new Winning(winning);
        this.bonus = new Bonus(bonus);
        this.winningMoney = 0;
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
