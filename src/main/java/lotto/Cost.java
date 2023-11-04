package lotto;

import lotto.view.InputView;

public class Cost {
    private final int cost;
    public Cost(int cost) {
        validate(cost);
        this.cost = cost;
    }

    private void validate(int cost){
        InputView inputView = new InputView();
    }
}
