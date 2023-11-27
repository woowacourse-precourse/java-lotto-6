package lotto.view;

import java.util.List;

import static lotto.view.ConstantsMessage.*;

public class LottoOutput {

    public void buyLottoNumberPrint(List<List<Integer>> lottoNumber) {
        printNewLine();
        System.out.println(lottoNumber.size()+BUY_RESULT_MESSAGE.getMessage());
        lottoNumber.forEach(System.out::println);
    }
    private void printNewLine() {
        System.out.println();
    }
}
