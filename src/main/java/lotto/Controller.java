package lotto;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.utils.Converter;
import lotto.utils.randomNumbersLotto;
import lotto.view.InputView;
import lotto.view.outputView;

public class Controller {

    private final Converter<String, Integer> converterNumber;
    private final Converter<String, List<Integer>> seperateComma;


    public Controller(Converter<String, Integer> converterNumber, Converter<String, List<Integer>> seperateComma) {
        this.converterNumber = converterNumber;
        this.seperateComma = seperateComma;
    }

    public void tempInputOutputController() {

    }

    private int purchaseLotto() {
        InputView inputView = new InputView();
        String inputPurchase = inputView.howMuchBuyLotto();
        int purchase = converterNumber.convert(inputPurchase);
        // 추후에 이 값이 유효한지 확인해보는 과정 넣기
        return purchase;
    }

    private List<Lotto> buyLottos(int count) {
        randomNumbersLotto randomNumbersLotto = new randomNumbersLotto();
        outputView outputview = new outputView();

        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomNumbersLotto.makeRandomNumLottos())).collect(
                        Collectors.toList());
        outputview.printLotto(lottos);
        return lottos;
    }


}
