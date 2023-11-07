package lotto.domain;

import static lotto.values.LottoInformation.LOTTO_PRICE;
import static lotto.values.LottoInformation.MAX_VALUE;

public class OrderCalculator implements Calculator{
    private int inputNum;
    public OrderCalculator(String input){
        inputNum = Integer.parseInt(input);
    }
    @Override
    public int compute() {
        return inputNum/LOTTO_PRICE.getValue();
    }

    public boolean checkThousands(){
        return inputNum%LOTTO_PRICE.getValue()==0;
    }

    public boolean tooMuchValue(){
        return inputNum>MAX_VALUE.getValue();
    }
}
