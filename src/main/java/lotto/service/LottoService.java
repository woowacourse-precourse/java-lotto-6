package lotto.service;

import lotto.model.LotteryMachine;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningNumbers;
import lotto.utils.LottoExceptions;
import lotto.utils.Prizes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService {
    private final LotteryMachine lotteryMachine = LotteryMachine.getInstance();
    private final User user = new User();
    private WinningNumbers winningNumbers;


    public void buyLotto(){
        List<Lotto> lottoDrawn = new ArrayList<>();
        for (int i = 0; i < (user.getPayed() / 1000); i++){
            Lotto lotto = new Lotto(lotteryMachine.draw());
            lottoDrawn.add(lotto);
        }
        user.setLottos(lottoDrawn);
    }

    public void setMoney(String money){
        if (!money.matches("[0-9]+")){
            throw new IllegalArgumentException(LottoExceptions.InputTypeError.getErrorMessage());
        }
        int payed = Integer.parseInt(money);
        if (payed == 0 || payed % 1000 != 0){
            throw new IllegalArgumentException(LottoExceptions.CurrencyUnitError.getErrorMessage());
        }
        user.setPayed(payed);
    }

    public User getUser(){
        return user;
    }

    public HashMap<Prizes, Integer> getNumberMatches(){
        HashMap<Prizes, Integer> matchCounts = new HashMap<>();
        for (Lotto lotto : user.getLottos()){
            int matchCount = winningNumbers.compare(lotto);
            Prizes tier = Prizes.findByMatchCount(matchCount);
            if (matchCount == 5 && winningNumbers.matchesBonus(lotto)){
                tier = Prizes.Second;
            }
            matchCounts.put(tier, matchCounts.getOrDefault(tier, 0) + 1);
        }
        return matchCounts;
    }

    public double calculatePercentage(HashMap<Prizes, Integer> matches){
        int firstPrize = matches.getOrDefault(Prizes.First, 0) * 2000000000;
        int secondPrize = matches.getOrDefault(Prizes.Second, 0) * 30000000;
        int thirdPrize = matches.getOrDefault(Prizes.Third, 0) * 1500000;
        int fourthPrize = matches.getOrDefault(Prizes.Fourth, 0) * 50000;
        int fifthPrize = matches.getOrDefault(Prizes.Fifth, 0) * 5000;
        return ((double)(firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize) / user.getPayed());
    }

    public void setWinningNumbers(String[] promptedNumbers) {
       winningNumbers = new WinningNumbers(promptedNumbers);
    }

    public void setBonusNumber(String bonus){
        winningNumbers.setBonus(bonus);
    }
}
