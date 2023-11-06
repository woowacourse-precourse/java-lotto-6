package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Util.RandomNumberUtil;
import lotto.view.InputView;

class Client {
    private int amountNumber;
    private static final int LOTTO_PRICE = 1000;
    private List<List<Integer>> AutoGenerateLottoNumberList;

    public Client() {
        setAmountNumber();
        setAutoGenerateLottoNumberList();
    }

    public void setAmountNumber() {
        amountNumber = inputAmountNumber();
    }

    public void setAutoGenerateLottoNumberList() {
        AutoGenerateLottoNumberList = new ArrayList<>();
        IntStream.range(0, amountNumber)
                .forEach(i -> AutoGenerateLottoNumberList.add(generateAutoLottoNumberList()));
    }

    private int inputAmountNumber() {
        return InputView.inputAmount() / LOTTO_PRICE;
    }

    private List<Integer> generateAutoLottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        RandomNumberUtil.generateRandomNumberList(lottoNumberList);
        return lottoNumberList;
    }
}