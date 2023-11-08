package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GenerateRandomLotto {

    public static final int ONE_LOTTO_AMOUNT = 1000;
    //TODO : 입력 값에 대한 검증 필요할 듯
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> autoLottoList;

    public GenerateRandomLotto() {
        this.autoLottoList = AutoLottoList();
    }

    public List<Lotto> AutoLottoList() {
        List<Lotto> LottoList = new ArrayList<>();

        IntStream.range(0, provideAmount())
                .forEach(i -> LottoList.add(Lotto.of(generateAutoLottoNumberList())));

        return LottoList;
    }

    private int provideAmount() {
        int money = InputView.inputAmount();
        return money / LOTTO_PRICE;
    }

    private static List<Integer> generateAutoLottoNumberList() {
        List<Integer> lottoNumberList = new ArrayList<>();
        return RandomNumber.generateRandomNumberList(lottoNumberList);
    }

    public void printAmount() {
        System.out.println(String.format(OutputView.BUYING_COUNT, autoLottoList.size()));
    }

    public List<Lotto> getLottoList() {
        return autoLottoList;
    }
}
