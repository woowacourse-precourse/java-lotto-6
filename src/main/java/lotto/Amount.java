package lotto;

public class Amount {

    private final static int UNIT = 1000;

    private final int amount;

    public Amount(int amount){
        validateIsThousand(amount);
        validateIsPositive(amount);
        this.amount = amount;
    }

    private void validateIsThousand(int amount) {
        if(amount % UNIT != 0) throw new IllegalArgumentException();
    }

    private void validateIsPositive(int amount){
        if(amount <= 0) throw new IllegalArgumentException();
    }
}
