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
    }

    public void askBonusNumber() {
    }

    public void showResult(LottoResultDto lottoResultDto) {
    }
}
