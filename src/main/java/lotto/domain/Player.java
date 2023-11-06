package lotto.domain;


import lotto.view.OutputView;

public class Player {
    private final int money;
    private int ticket;

    public Player(String input) {
        this.money = Integer.parseInt(input);
    }

    public void divideMoneyByThousand() {
        OutputView outputView = new OutputView();
        this.ticket = money / ConstantValue.THOUSAND;
        outputView.displayLottoNumbers(ticket);
    }
}
