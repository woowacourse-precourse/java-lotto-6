package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.MyLottosDto;
import lotto.Dto.SingleResultDto;
import lotto.Dto.TotalResultDto;
import lotto.constant.constants.Prize;
import lotto.constant.messages.Notification;


public class OutputView {
    public void askMoney() {
        System.out.println(Notification.BUDGET.getMessage());
    }

    public void showMyTickets(MyLottosDto myLottosDto) {
        System.out.printf(Notification.PURCHASED.getMessage(), myLottosDto.size());
        System.out.println();
        for (List<Integer> myLotto : myLottosDto.getMyLottos()) {
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
        List<Integer> printOrder = new ArrayList<>();
        addOrder(printOrder);
        for (Integer code : printOrder) {
            SingleResultDto singleResultDto = totalResultDto.getSingleResult(code);
            System.out.printf(Notification.RESULT_MATCHED.getMessage(), singleResultDto.getMatch());
            if (code.equals(Prize.FIVE_AND_BONUS_MATCHED.getCode())) {
                System.out.print(Notification.RESULT_BONUS.getMessage());
            }
            System.out.printf(Notification.RESULT_PRIZE.getMessage(), singleResultDto.getPrize());
            System.out.printf(Notification.RESULT_WON.getMessage(), singleResultDto.getWon());
            System.out.println();
        }
    }

    private void addOrder(List<Integer> printOrder) {
        printOrder.add(Prize.THREE_MATCHED.getCode());
        printOrder.add(Prize.FOUR_MATCHED.getCode());
        printOrder.add(Prize.FIVE_MATCHED.getCode());
        printOrder.add(Prize.FIVE_AND_BONUS_MATCHED.getCode());
        printOrder.add(Prize.SIX_MATCHED.getCode());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }


}
