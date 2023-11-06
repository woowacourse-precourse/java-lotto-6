package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.Constants;

public class PrintLottoUI {

    public void printLottoCount(int lottoCount) {

        System.out.println();
        System.out.println(lottoCount + Constants.BOUGHT_LOTTO_COUNT);
    }

    public void printLotto(List<Integer> numbers) {

        System.out.println(numbers);
    }
}
