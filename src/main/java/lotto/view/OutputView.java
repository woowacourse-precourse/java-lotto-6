package lotto.view;

import java.util.List;

import static lotto.util.MessageConstant.*;

public class OutputView {
    public void printLottoNumAndNumbers(int num, List<String> texts) {
        System.out.printf(LOTTO_NUM_OUTPUT, num);
        texts.forEach(System.out::println);
    }
}
