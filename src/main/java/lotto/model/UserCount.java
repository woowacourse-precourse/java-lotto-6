package lotto.model;

import lotto.view.ExceptionMessage;

public class UserCount {
    private static final int LOTTO_UNIT = 1000;
    private final int count;
    public UserCount(String payment){
        int paymentNum = toInt(payment);
        validate(paymentNum);
        this.count = calculateCount(paymentNum);
    }
    public int calculateCount(int payment){
        return payment/1000;
    }
    public int getCount(){
        return count;
    }
    public int toInt(String payment){
        try{
            return Integer.parseInt(payment);
        }
        catch (NumberFormatException e){
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }

    public void validate(int paymentNum){
        validateRange(paymentNum);
        validateUnit(paymentNum);
    }
    public void validateRange(int paymentNum){
        if(paymentNum<=0){
            ExceptionMessage.naturalNumException();
            throw new IllegalArgumentException();
        }
    }
    public void validateUnit(int paymentNum){
        if(paymentNum % LOTTO_UNIT != 0){
            ExceptionMessage.unitException();
            throw new IllegalArgumentException();
        }
    }
}
