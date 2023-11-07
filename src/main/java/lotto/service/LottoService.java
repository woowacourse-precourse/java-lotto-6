package lotto.service;

import lotto.model.LotteryMachine;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private LotteryMachine lotteryMachine = LotteryMachine.getInstance();
    private User user;
    private WinningNumbers winningNumbers;


    public void buyLotto(){
        List<Lotto> lottoDrawn = new ArrayList<>();
        for (int i = 0; i < (user.getPayed() / 1000); i++){
            Lotto lotto = new Lotto(lotteryMachine.draw());
            lottoDrawn.add(lotto);
        }
        user.setLottos(lottoDrawn);
    }

    public void setMoney(int money){
        user.setPayed(money);
    }

    public User getUser(){
        return user;
    }

    public void getNumberMatches(){
        for (Lotto lotto : user.getLottos()){
            int matchCount = winningNumbers.compare(lotto);
        }
    }

    public void setWinningNumbers(String[] winningNumbers) {
        winningNumbers = new WinningNumbers(winningNumbers);
    }
}
