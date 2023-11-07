package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Util.RandomNumberUtil;
import lotto.view.InputView;

class Client {
    private static final int LOTTO_PRICE = 1000;

    public static List<List<Integer>> setAutoGenerateLottoNumberList() {
        List<List<Integer>> AutoGenerateLottoNumberList = new ArrayList<>();
        IntStream.range(0, provideAmountNumber())
                .forEach(i -> AutoGenerateLottoNumberList.add(generateAutoLottoNumberList()));

        return AutoGenerateLottoNumberList;
    }
    
    private static List<Integer> generateAutoLottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        RandomNumberUtil.generateRandomNumberList(lottoNumberList);
        return lottoNumberList;
    }

    private static int provideAmountNumber() {
        int amountNumber = inputAmountNumber();
        return amountNumber;
    }

    private static int inputAmountNumber() {
        return InputView.inputAmount() / LOTTO_PRICE;
    }
}