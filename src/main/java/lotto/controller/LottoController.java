package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.converter.NumericConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_PRICE = 1000;
    private final NumericConverter numericConverter = new NumericConverter();
    private final InputView inputView = new InputView();
    private final OutputView  outputView = new OutputView();

    public void run(){
        int amount = getAmount();
        Lottos lottos = new Lottos(buyLotto(amount));

    }

    private int getAmount(){
        String input = inputView.readAmount();
        int amount = numericConverter.convert(input)/LOTTO_PRICE;
        outputView.printAmount(amount);
        return amount;
    }

    private List<Lotto> buyLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(
                        i -> new Lotto(
                                Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH)))
                .collect(Collectors.toList());
    }


}
