package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.UserInput;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static lotto.utils.PrintUtil.*;
import static lotto.constValue.ConstNumber.*;
import static lotto.core.Random.*;

public class Lottery {
    private UserInput userInput;
    private List<Lotto> lottos;
    private WinningNumber winningNumbers;
    private HashMap<Prize, Integer> prizes;
    private int countOfLotto;

    public Lottery(){
        this.userInput = new UserInput();
        this.lottos = new ArrayList<>();
        this.countOfLotto = 0;
        this.prizes = new HashMap<>();
    }

    public void play(){
        ready();
        start();
        end();
    }

    private void ready(){
        printPricePrompt();
        userInput.inputLottoPrice();

        this.countOfLotto = userInput.getLottoPrice()/LOTTO_PRICE;

        printLottoCount(countOfLotto);

        for(int i=0;i<countOfLotto;i++){
            setLottos(getRandomNumbers());
        }

        printWinningNumberPrompt();
        userInput.inputWinningNumbers();

        printBonusNumberPrompt();
        userInput.inputBonusNumber();

        winningNumbers = new WinningNumber(
                userInput.getWinningNumbers(),
                userInput.getBonusNumber()
        );

        for(Prize prize:Prize.values()){
            prizes.put(prize,0);
        }
    }

    private void start(){
        for(Lotto currentLotto:lottos){
            int countMatching = compareLotto(currentLotto);
            boolean hasBonus = hasBonusNumber(currentLotto);

            for(Prize prize:prizes.keySet()){
                if ((countMatching == prize.getMatchingCount()) && (hasBonus || !prize.hasBonus())) {
                    int count = prizes.get(prize);
                    count += 1;
                    prizes.put(prize,count);
                }
            }
        }
    }

    private void end(){
        printTotalWinningResult();

        double totalPrice = 0;

        for(Prize prize:Prize.values()){
            if(prizes.containsKey(prize)){
                int count = prizes.get(prize);
                printPlace(prize.getPrizeResult(count));
                totalPrice += prize.getPrice(count);
            }
        }

        double totalProfit = totalPrice / userInput.getLottoPrice() * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedProfitPercentage = df.format(totalProfit);

        printProfit(formattedProfitPercentage);
    }

    private void setLottos(List<Integer> randomNumbers){
        Lotto newLotto = new Lotto(randomNumbers);
        printLottoNumbers(newLotto);
        lottos.add(newLotto);
    }

    public int compareLotto(Lotto lotto){
        int count = 0;

        List<Integer> winningNumber = winningNumbers.getWinningNumbers().getNumbers();

        for (Integer number : winningNumber) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

}
