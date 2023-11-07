package lotto.io;

import java.util.Map;
import lotto.domain.LottoReceipt;
import lotto.domain.Rank;

public class ConsoleLottoOutput implements LottoOutput {
    private final String MESSAGE_ASKING_MONEY = "구입금액을 입력해 주세요.";
    private final String MESSAGE_RECEIPT_MESSAGE = "개를 구매했습니다.";
    private final String MESSAGE_ASKING_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String MESSAGE_ASKING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    @Override
    public void printAskingMoney() {
        System.out.println(MESSAGE_ASKING_MONEY);
    }

    @Override
    public void printLottoReceipt(LottoReceipt receipt) {
        System.out.println(receipt.getLotteryCount() + MESSAGE_RECEIPT_MESSAGE);
//        recipt
    }

    @Override
    public void printAskingWinningNumbers() {

    }

    @Override
    public void printAskingBonusNumber() {

    }

    @Override
    public void printResults(Map<Rank, Integer> result) {

    }

    @Override
    public void printProfitAsPercentage(Map<Rank, Integer> result) {

    }
}
