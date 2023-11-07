package lotto;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.model.WinningNumber;
import lotto.service.CreateLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Payment payment = new Payment();
        CreateLotto createLotto = new CreateLotto();


        int money = 0;
        int ticket = 0;
        List<Integer> winning;
        int bonus=0;

        while (true){
            try {
                money = inputView.getPaymentInput();
                payment.Payment(money);
                break;
            }catch (Exception e){
            }
        }
        ticket = payment.ticketNumber(money);
        outputView.printTicketNumber(ticket);

        List<Lotto> lottos = createLotto.createLottos(ticket);
        outputView.printLottoList(ticket, lottos);

        while (true){
            try {
                winning = inputView.getWinningInput();
                WinningNumber winningNumber = new WinningNumber(winning);
                System.out.println(winning);
                break;
            }catch (Exception e){
            }
        }

        while (true){
            try {
                bonus = inputView.getBonusInput();
                BonusNumber bonusNumber = new BonusNumber(bonus, winning);
                System.out.println(bonus);
                break;
            }catch (Exception e){
            }
        }

    }
}
