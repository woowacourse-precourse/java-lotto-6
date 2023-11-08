package lotto.Domain;

import lotto.Exception.DivideMoneyException;
import lotto.Exception.ZeroMoneyException;

public class Money {
    private static  final int ZERO = 0;
    private static  final int THOUSAND =1000;
    private final int money;

    public Money(int money){
        validate(money);
        this.money=money;
    }

   public void validate(int inputValue){
        validateZero(inputValue);
        validateDivideMoeny(inputValue);
   }

   private void validateZero(int inputValue){
        if(inputValue == ZERO){
            throw new ZeroMoneyException();
        }
   }

   private void validateDivideMoeny(int inputValue){
       if(inputValue % THOUSAND != ZERO){
           throw new DivideMoneyException();
       }
   }
   public int getTicket(){
        return money/1000;
   }
}
