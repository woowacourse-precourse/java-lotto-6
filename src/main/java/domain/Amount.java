package domain;

import static service.RandomNumber.getRandomNumber;
import static util.ErrorMessage.CANT_DIVIDE_AMOUNT;
import static util.ErrorMessage.NOT_POSITIVE_AMOUNT;
import static util.ProgressMessage.OUTPUT_TICKET_COUNT;
import static view.InputView.inputLottoPurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class Amount{
    private final int amount;
    private final int count;
    private final int LOTTO_TICKET_PRICE = 1000;
    public Amount(int amount){
        validate(amount);
        this.amount = amount;
        this.count = amount/LOTTO_TICKET_PRICE;
    }

    private void validate(int amount) {
        if(!validateIsPositive(amount) || !validateIsDivisible(amount)){
            inputLottoPurchaseAmount();
        }
    }

    private boolean validateIsPositive(int amount) {
        try{
            if(amount <= 0){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(NOT_POSITIVE_AMOUNT.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateIsDivisible(int amount) {
        try {
            if (amount % LOTTO_TICKET_PRICE != 0) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e) {
            System.out.println(CANT_DIVIDE_AMOUNT.getErrorMessage());
            return false;
        }
        return true;
    }
    public void outputLottoPurchaseAmount(){
        System.out.println(count + OUTPUT_TICKET_COUNT.getProgressMessage());
    }

    public Lottos buyLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<count;i++) {
            lottos.add(getRandomNumber());
        }
        return new Lottos(lottos);
    }
}

