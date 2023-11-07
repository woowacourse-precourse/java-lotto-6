package lotto.service;

import lotto.model.LotteryMachine;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningNumbers;
import lotto.utils.Constants;
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
        for (int i = 0; i < (user.getPayed() / Constants.CURRENCY_UNITS); i++){
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
        if (payed == 0 || payed % Constants.CURRENCY_UNITS != 0){
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
        int firstPrize = matches.getOrDefault(Prizes.First, 0) * Constants.FIRST_PRIZE;
        int secondPrize = matches.getOrDefault(Prizes.Second, 0) * Constants.SECOND_PRIZE;
        int thirdPrize = matches.getOrDefault(Prizes.Third, 0) * Constants.THIRD_PRIZE;
        int fourthPrize = matches.getOrDefault(Prizes.Fourth, 0) * Constants.FOURTH_PRIZE;
        int fifthPrize = matches.getOrDefault(Prizes.Fifth, 0) * Constants.FIFTH_PRIZE;
        return ((double)(firstPrize + secondPrize + thirdPrize + fourthPrize + fifthPrize) / user.getPayed());
    }

    public void setWinningNumbers(String[] promptedNumbers) {
       winningNumbers = new WinningNumbers(promptedNumbers);
    }

    public void setBonusNumber(String bonus){
        winningNumbers.setBonus(bonus);
    }
}
