package lotto.view;

import static lotto.enumerate.Message.LOTTO_BUYED;

import java.util.List;

public class OutputView {
    public void printLottoList(int lottoListNumber, List<String> lottoListString) {
        System.out.printf((LOTTO_BUYED.getMessage()), lottoListNumber);
        lottoListString.forEach(System.out::println);
    }
    public void printWinningList(String winningList) {
        System.out.printf(winningList);
    }

}
