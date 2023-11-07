package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.MyLottosDto;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
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

    public void showResult(TotalResultDto totalResultDto) {
        System.out.println(Notification.RESULT_PRE.getMessage());
        List<Integer> order = new ArrayList<>(List.of(3, 4, 5, 7, 6));
        for (Integer x : order) {
            SingleResultDto singleResultDto = totalResultDto.getSingleResult(x);
            System.out.printf(Notification.RESULT_MATCHED.getMessage(), singleResultDto.getMatch());
            if (x == 7) {
                System.out.print(Notification.RESULT_BONUS.getMessage());
            }
            System.out.printf(Notification.RESULT_PRIZE.getMessage(), singleResultDto.getPrize());
            System.out.printf(Notification.RESULT_WON.getMessage(), singleResultDto.getWon());
            System.out.println();
        }
        System.out.printf(Notification.RESULT_PROFIT.getMessage(), totalResultDto.getProfit());
        System.out.println();
    }


}
