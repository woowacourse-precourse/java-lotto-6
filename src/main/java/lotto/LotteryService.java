package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LotteryService {
    private int totalLottoAmount;
    private int bonusNumber;
    List<Lotto> buyLottoSet = new ArrayList<Lotto>();
    List<Integer> winningNumber = new ArrayList<Integer>();
    Validation validator = new Validation();
    DataInput inputSets = new DataInput();
    DataOutput outputSets = new DataOutput();

    public LotteryService(){
        this.totalLottoAmount = 0;
        this.bonusNumber = -1;
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
}
