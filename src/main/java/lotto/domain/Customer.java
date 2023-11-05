package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.SystemOption.PAYMENT_UNIT_VALUE;

public class Customer {
    private List<Lotto> lottos;
    private int payment;
    private int numberOfLottos;
    private List<Result> results;

    public Customer(int payment) {
        this.lottos = new ArrayList<>();
        this.payment = payment;
        this.numberOfLottos = payment / PAYMENT_UNIT_VALUE.getValue();
        this.results = new ArrayList<>();
    }

    public static Customer createCustomer(int payment) {
        return new Customer(payment);
    }

    public int getNumberOfLottos() {
        return this.numberOfLottos;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public int getPayment() {
        return this.payment;
    }

    public void buyLottos() {
        for (int i = 0; i < this.numberOfLottos; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            Lotto lotto = Lotto.createLotto(lottoNumbers);
            this.lottos.add(lotto);
        }
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<String> getInfoOfLottos() {
        return this.lottos.stream()
                .map(lotto -> lotto.getNumbersInfo())
                .collect(Collectors.toList());
    }

    public void calculateResult(Target target) {
        for (Lotto lotto : lottos) {
            Result result = lotto.compareWith(target);
            results.add(result);
        }
    }

}
