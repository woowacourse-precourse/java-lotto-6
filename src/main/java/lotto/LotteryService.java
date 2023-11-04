package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LotteryService {
    private int totalLottoAmount;
    List<Lotto> buyLottoSet = new ArrayList<Lotto>();
    List<Integer> winningNumber = new ArrayList<Integer>();
    Validation validator = new Validation();

    public LotteryService(){
        this.totalLottoAmount = 0;
    }

    public void purchaseLotto(){
        DataInput inputPurchasePayment = new DataInput();
        DataOutput outputMessage = new DataOutput();
        int totalPurchasePayment;

        outputMessage.printProgressMessage(Progress.PURCHASE);
        totalPurchasePayment = inputPurchasePayment.userInputPayment();

        if(!validator.isPaymentDivided(totalPurchasePayment)){
            throw new IllegalArgumentException();
        }

        this.totalLottoAmount = totalPurchasePayment / 1000;
        System.out.print(this.totalLottoAmount);
        outputMessage.printProgressMessage(Progress.BUY);
    }

    public void makeRandomLottoNumbers(){
        DataOutput outputMessage = new DataOutput();
        for(int i = 0; i < this.totalLottoAmount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(numbers);
            buyLottoSet.add(newLotto);
            outputMessage.printPurchaseLottoNumbers(numbers);
        }
    }

    public void makeWinningNumber(){
        DataInput inputWinningNumber = new DataInput();
        DataOutput outputMessage = new DataOutput();
        outputMessage.printProgressMessage(Progress.WINNING);
        this.winningNumber = inputWinningNumber.userInputWinningNumbers();
    }
}
