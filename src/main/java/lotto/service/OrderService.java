package lotto.service;

import lotto.domain.OrderCalculator;
import lotto.values.ExceptionMessage;

import static lotto.values.ExceptionMessage.*;

public class OrderService {
    private OrderCalculator calculator;
    public ExceptionMessage checkException(String input){
        if(input.length()==0) return NOT_NULL;
        if(!input.matches(ONLY_NUMBER.getMessage())){
            return NOT_NUMBER;
        }

        this.calculator = new OrderCalculator(input);
        if(!calculator.checkThousands()){
            return CAN_NOT_PURCHASE;
        }
        if(calculator.tooMuchValue()){
            return TOO_MUCH_MONEY;
        }

        return null;
    }
    public int executeOrder(){
        return calculator.compute();
    }

}
