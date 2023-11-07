package lotto;

public enum InputType { purchaseMoney(0), catchNumber(1);
    private int value;
    InputType(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
