package lotto.controller;

import lotto.model.Lotto;
import lotto.utils.Constant;
import lotto.utils.InputUtils;
import lotto.utils.RandomUtils;
import lotto.utils.ValidateUtils;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Constant.*;
import static lotto.view.OutputView.*;

public class LottoService {

    private List<Lotto> lottos = new ArrayList<>();

    public int setLottoCount(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    public void makeRandomLottos(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = makeRandomLotto();
            lottos.add(lotto);
        }
    }

    public void outputLottos() {
        for(Lotto lotto : lottos) {
            List<String> numbers = typeConversionNumbers(lotto.getNumbers());
            outputLottoNumbers(numbers);
        }
    }

    private Lotto makeRandomLotto() {
        List<Integer> randomNumbers = RandomUtils.makeRandomNumbers();
        return new Lotto(randomNumbers);
    }

    public Lotto makeWinningLotto() {
        try{
            String input = InputUtils.input();
            List<String> separateNumbers = separateInput(input);
            ValidateUtils.validateNumbersNumeric(separateNumbers);
            List<Integer> numbers = winningLottoTypeConversion(separateNumbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningLotto();
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private List<Integer> winningLottoTypeConversion(List<String> separateNumbers) {
        return separateNumbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<String> separateInput(String input) {
        return Arrays.asList(input.split(","));
    }

    private List<String> typeConversionNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
