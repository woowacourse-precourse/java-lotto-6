package lotto.model;

public class PurchaseMoney {

    private static final int ONE_THOUSAND = 1000;

    private int value;

    public PurchaseMoney(String money){
        validate(money);
        this.value = Integer.valueOf(money);
    }

    public int getValue(){
        return value;
    }

    private void validate(String money){

        if(isEmpty(money)){
            throw new IllegalArgumentException();
        }

        if(!isDigit(money)){
            throw new IllegalArgumentException();
        }

        if(isLessThanOneThousand(money)){
            throw new IllegalArgumentException();
        }

        if(!isDividedByOneThousand(money)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String money){
        return money.isBlank() || money == null;
    }

    private boolean isDigit(String money){
        for (int i = 0; i < money.length(); i++) {
            if(!Character.isDigit(money.charAt(i))) return false;
        }

        return true;
    }

    private boolean isDividedByOneThousand(String money){
        return Integer.valueOf(money) % ONE_THOUSAND == 0;
    }

    private boolean isLessThanOneThousand(String money){
        return Integer.valueOf(money) < ONE_THOUSAND;
    }
}
