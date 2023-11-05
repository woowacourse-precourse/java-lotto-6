package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LotteryService {
    private int totalLottoAmount;
    private int bonusNumber;
    List<Lotto> buyLottoSet;
    List<Integer> winningNumber;
    Validation validator;
    DataInput inputSets;
    DataOutput outputSets;
    Prize prize;

    public LotteryService(){
        this.totalLottoAmount = 0;
        this.bonusNumber = -1;
        buyLottoSet = new ArrayList<Lotto>();
        winningNumber = new ArrayList<Integer>();
        validator = new Validation();
        inputSets = new DataInput();
        outputSets = new DataOutput();
        prize = new Prize();
    }

    public void purchaseLotto(){
        int totalPurchasePayment;
        outputSets.printProgressMessage(Progress.PURCHASE);
        totalPurchasePayment = inputSets.userInputPayment();

        if(!validator.isPaymentDivided(totalPurchasePayment)){
            throw new IllegalArgumentException();
        }
        this.totalLottoAmount = totalPurchasePayment / 1000;

        System.out.print(this.totalLottoAmount);
        outputSets.printProgressMessage(Progress.BUY);
    }

    public void makeRandomLottoNumbers(){
        for(int i = 0; i < this.totalLottoAmount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto newLotto = new Lotto(numbers);
            buyLottoSet.add(newLotto);
            outputSets.printPurchaseLottoNumbers(numbers);
        }
    }

    public void makeWinningNumber(){
        outputSets.printProgressMessage(Progress.WINNING);
        this.winningNumber = inputSets.userInputWinningNumbers();
    }

    public void makeBonusNumber(){
        outputSets.printProgressMessage(Progress.BONUS);
        this.bonusNumber = inputSets.userInputBonusNumber();
    }

    public void checkEveryLottoMatch(){
        for(int i = 0; i < this.totalLottoAmount; i++){
            checkEachLottoMatch(buyLottoSet.get(i));
        }
    }

    public void checkEachLottoMatch(Lotto toCheckLotto){
        int winningCount = checkPrizeNumberMatch(toCheckLotto);

        if(winningCount == 5 && checkBonusNumberMatch(toCheckLotto)){
            return;
        }
        prize.addPrize(7 - winningCount);
    }

    public int checkPrizeNumberMatch(Lotto toCheckLotto){
        int winningCount = 0;
        List<Integer> toCheckLottoNumbers = toCheckLotto.getNumbers();

        for(int i = 0; i < 6; i++){
            if(toCheckLottoNumbers.contains(winningNumber.get(i))){
                winningCount++;
            }
        }

        return winningCount;
    }

    public boolean checkBonusNumberMatch(Lotto toCheckLotto){
        if(toCheckLotto.getNumbers().contains(this.bonusNumber)) {
            prize.addPrize(0);
            return true;
        }
        return false;
    }
}
