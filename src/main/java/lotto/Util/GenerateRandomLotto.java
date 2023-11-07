package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.InputHandler;
import lotto.domain.Lotto;

public class GenerateRandomLotto {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> AutoGenerateLottoList() {
        List<Lotto> LottoList = new ArrayList<>();
        IntStream.range(0, provideAmountNumber())
                .forEach(i -> LottoList.add(Lotto.of(generateAutoLottoNumberList())));

        return LottoList;
    }

    private static List<Integer> generateAutoLottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        RandomNumber.generateRandomNumberList(lottoNumberList);
        return lottoNumberList;
    }

    private static int provideAmountNumber() {
        int amountNumber = InputHandler.inputAmountNumber() / LOTTO_PRICE;
        return amountNumber;
    }
}
