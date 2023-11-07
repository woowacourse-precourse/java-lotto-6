package lotto.service;

import lotto.domain.OrderCalculator;
import lotto.values.ExceptionMessage;

import static lotto.values.ExceptionMessage.*;

public class OrderService {
    private OrderCalculator calculator;
    public boolean checkException(String input){
        if(input.length()==0) throw new IllegalArgumentException(NOT_NULL.getMessage());
        if(!input.matches(ONLY_NUMBER.getMessage())) throw new IllegalArgumentException(NOT_NUMBER.getMessage());

        this.calculator = new OrderCalculator(input);

        if(!calculator.checkThousands()) throw new IllegalArgumentException(CAN_NOT_PURCHASE.getMessage());
        if(calculator.tooMuchValue()) throw new IllegalArgumentException(TOO_MUCH_MONEY.getMessage());

        return true;
    }
    public int executeOrder(){
        return calculator.compute();
    }

}
