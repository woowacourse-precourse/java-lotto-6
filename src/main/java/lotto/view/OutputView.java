package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.Dto.BoughtLottosDto;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Prize;
import lotto.constant.messages.Notification;


public class OutputView {
    public void askMoney() {
        System.out.println(Notification.BUDGET.getMessage());
    }

    public void showMyTickets(BoughtLottosDto boughtLottosDto) {
        System.out.printf(Notification.PURCHASED.getMessage(), boughtLottosDto.size());
        System.out.println();

        for (List<Integer> myLotto : boughtLottosDto.getMyLottos()) {
            Collections.sort(myLotto);
            System.out.println(myLotto);
        }
    }

    public void askWinningLotto() {
        System.out.println(Notification.WINNING_LOTTO.getMessage());
    }

    public void askBonusNumber() {
        System.out.println(Notification.BONUS_LOTTO.getMessage());
    }

    public void showResult(TotalResultDto totalResultDto) {
        System.out.println(Notification.RESULT_PRE.getMessage());
        printWonLottos(totalResultDto);
        System.out.printf(Notification.RESULT_PROFIT.getMessage(), totalResultDto.getProfit());
        System.out.println();
    }

    private void printWonLottos(TotalResultDto totalResultDto) {
        for (int i = 0; i < totalResultDto.size(); i++) {
            SingleResultDto singleResultDto = totalResultDto.get(i);
            System.out.printf(Notification.RESULT_MATCHED.getMessage(), singleResultDto.getMatch());
            if (singleResultDto.getPrize() == Prize.FIVE_AND_BONUS_MATCHED.getPrize()) {
                System.out.print(Notification.RESULT_BONUS.getMessage());
            }
            System.out.printf(Notification.RESULT_PRIZE.getMessage(), singleResultDto.getPrize());
            System.out.printf(Notification.RESULT_WON.getMessage(), singleResultDto.getWon());
            System.out.println();
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}