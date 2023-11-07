package lotto.Service;

import lotto.Domain.PlayerPrice;
import lotto.View.InputView;
import lotto.View.OutputView;

public class PlayerInputManagerService {
    private final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public PlayerPrice inputPlayerAddInfo() {
        PlayerPrice playerPrice = new PlayerPrice(inputBuyingPay());
        setPlayerLottoTickets(playerPrice);
        showIssuedLottoNumber(playerPrice);
        return playerPrice;
    }

    public int inputBuyingPay() {
        outputView.requestBuyingPayPrompt();
        return inputView.buyingPayConsole();
    }

    public static void setPlayerLottoTickets(PlayerPrice playerPrice) {
        outputView.printIssuedLottoTickets(playerPrice);
        playerPrice.setUpLottoTickets(getBuyingPay(playerPrice));
    }

    public void showIssuedLottoNumber(PlayerPrice playerPrice) {
        outputView.printIssuedLottoNumbers(playerPrice);
    }

    public static int getBuyingPay(PlayerPrice playerPrice) {
        return playerPrice.getBuyingPay();
    }
}
