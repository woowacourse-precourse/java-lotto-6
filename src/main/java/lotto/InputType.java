package lotto;

public enum InputType { purchaseMoney(0), catchNumber(1);
    private final int value;
    InputType(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
