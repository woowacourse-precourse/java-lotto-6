package lotto.play;

import lotto.lotto.LottoShop;
import lotto.lotto.WinnerLotto;
import lotto.player.Prize;
import lotto.player.Wallet;

public class Game {
    private Wallet wallet;
    private int prizeCount;
    private LottoShop lottoShop;

    public Game(){
        prizeCount = 0;
        wallet = new Wallet();
        lottoShop = new LottoShop();
    }



    public void play(){
        lottoShop.buy(wallet);
        wallet.printMyLotto();

        WinnerLotto winnerLotto = lottoShop.pickWinnerLotto();

        Prize prize = new Prize();

        prize.calculateWinLotto(wallet,winnerLotto);
        prize.printTotalResult();
        prize.printTotalWinRate(wallet);

    }
}
