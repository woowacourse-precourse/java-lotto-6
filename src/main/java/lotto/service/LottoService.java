package lotto.service;

import lotto.model.Lotto;
import lotto.model.Payment;

import java.util.List;

public class LottoService {

    public void initLottoAmount(String inputAmount) {
        Payment payment = new Payment(inputAmount);
    }

    public void initLottoNumber(List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
