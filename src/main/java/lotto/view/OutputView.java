package lotto.view;

import java.util.List;
import lotto.Dto.LottoResultDto;
import lotto.Dto.MyLottosDto;
import lotto.constants.messages.Notification;


public class OutputView {
    public void askMoney() {
        System.out.println(Notification.BUDGET.getMessage());
    }

    public void showMyTickets(MyLottosDto myLottosDto) {
        for (List<Integer> myLotto : myLottosDto.getMyLottosNumber()) {
            System.out.println(myLotto);
        }
    }

    public void askWinnerNumber() {
        System.out.println(Notification.WINNER_LOTTO.getMessage());
    }

    public void askBonusNumber() {
        System.out.println(Notification.BONUS_LOTTO.getMessage());
    }

    public void showResult(LottoResultDto lottoResultDto) {
        System.out.println(Notification.RESULT_PRE.getMessage());
        for (List<Integer> x : lottoResultDto.getResult()) {
            System.out.printf(Notification.RESULT_MATCHED.getMessage(), x.get(0), x.get(2), x.get(3));
            System.out.println();
        }
        System.out.printf(Notification.RESULT_PROFIT.getMessage(), lottoResultDto.getProfit());
        System.out.println();

    }
}
