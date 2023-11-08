package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.Player;
import lotto.util.LottoAgency;
import lotto.domain.LottoDrawingMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {


    public void startGame() {
        Player player = inputAmount();
        ticketingLotto(player);


        Lotto winningBall = createLotto();
        LottoBall bonusBall = createBonusBall();
    }

    private static Player inputAmount() {
        try {
            return new Player(InputView.inputAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputAmount();
        }
    }

    private void ticketingLotto(Player player) {
        int quantity = player.getPlayerTicketQuantity();
        OutputView.printBuyingTicketQuantity(player);
        player.setLottoTicket(LottoAgency.createAutoTicket(quantity));

        OutputView.printPlayerLottoTicketInfo(player);
    }

    private Lotto createLotto() {
        List<String> lottoBallList = InputView.inputWiningLottoNumbers();

        try{
            return LottoDrawingMachine.LottoDrawingMachine(lottoBallList);
        }catch (IllegalArgumentException e){
            OutputView.printException(e);
            return createLotto();
        }
    }

    private LottoBall createBonusBall(){
        try{
            return new LottoBall(InputView.inputWiningBonusLottoNumber());
        }catch (IllegalArgumentException e){
            OutputView.printException(e);
            return createBonusBall();
        }
    }
}
