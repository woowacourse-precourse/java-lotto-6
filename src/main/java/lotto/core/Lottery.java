package lotto.core;

import lotto.utils.UserInput;
import lotto.utils.Validator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.utils.PrintUtil.*;
import static lotto.constValue.ConstNumber.*;
import static lotto.core.Random.*;

public class Lottery {
    private final UserInput userInput;
    private final List<Lotto> lottos;
    private WinningNumber winningNumbers;
    private final HashMap<Prize, Integer> prizes;
    private int countOfLotto;

    public Lottery(){
        this.userInput = new UserInput();
        this.lottos = new ArrayList<>();
        this.countOfLotto = 0;
        this.prizes = new HashMap<>();
    }

    public void ready(){
        getLottoPrice();
        this.countOfLotto = userInput.getLottoPrice()/LOTTO_PRICE;
        getRandomLottoNumbers();

        getWinningNumbers();
        initializePrizes();
    }

    private void getLottoPrice(){
        printPricePrompt();
        userInput.inputLottoPrice();
        printNewLine();
    }

    private void getRandomLottoNumbers(){
        printLottoCount(countOfLotto);
        for(int i=0;i<countOfLotto;i++){
            List<Integer> newRandomNumbers = getRandomNumbers();
            Validator.validateAscending(newRandomNumbers);
            setLottos(newRandomNumbers);
        }
        printNewLine();
    }

    private void getWinningNumbers(){
        printWinningNumberPrompt();
        userInput.inputWinningNumbers();
        printNewLine();

        printBonusNumberPrompt();
        userInput.inputBonusNumber();
        printNewLine();

        winningNumbers = new WinningNumber(
                userInput.getWinningNumbers(),
                userInput.getBonusNumber()
        );
    }

    private void initializePrizes(){
        for(Prize prize:Prize.values()){
            prizes.put(prize,0);
        }
    }

    public void start(){
        for(Lotto currentLotto:lottos){
            int countMatching = compareLotto(currentLotto);
            boolean hasBonus = hasBonusNumber(
                    currentLotto,
                    this.winningNumbers.getBonusNumber()
            );

            for(Prize prize:prizes.keySet()){
                if ((countMatching == prize.getMatchingCount()) && (hasBonus || !prize.hasBonus())) {
                    int count = prizes.get(prize);
                    count += 1;
                    prizes.put(prize,count);
                    break;
                }
            }
        }
    }

    public void end(){
        printTotalWinningResult();

        double totalPrice = getTotalPrice();
        String totalProfit = getTotalProfit(totalPrice);

        printProfit(totalProfit);
    }

    private double getTotalPrice(){
        double totalPrice = 0;

        for(Prize prize:Prize.values()){
            if(prizes.containsKey(prize)){
                int count = prizes.get(prize);
                printPlace(prize.getPrizeResult(count));
                totalPrice += prize.getPrice(count);
            }
        }

        return totalPrice;
    }

    private String getTotalProfit(double totalPrice){
        double totalProfit = totalPrice / userInput.getLottoPrice() * 100;
        DecimalFormat df = new DecimalFormat("#,###.0");
        return df.format(totalProfit);
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

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

}
