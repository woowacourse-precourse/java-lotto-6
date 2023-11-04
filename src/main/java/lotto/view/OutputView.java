package lotto.view;

import static lotto.enumerate.Message.LOTTO_BUYED;

import java.util.List;

public class OutputView {
    public void lottoListPrint(int lottoListNumber, List<String> lottoListString) {
        System.out.printf((LOTTO_BUYED.getMessage()), lottoListNumber);
        lottoListString.forEach(System.out::println);
    }
}
