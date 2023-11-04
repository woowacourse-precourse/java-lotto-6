package lotto.service;

import lotto.model.Lotto;
import lotto.model.Payment;

import java.util.Arrays;
import java.util.List;

public class LottoService {

    public void initLottoAmount(String inputAmount) {
        Payment payment = new Payment(inputAmount);
    }

    public void initLottoNumber(String inputLotto) {

        List<Integer> lottoNumbers = stringToList(inputLotto);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    public List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
