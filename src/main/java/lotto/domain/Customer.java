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
    private int countOfLottos;
    private List<Result> results;

    public Customer(int payment) {
        this.lottos = new ArrayList<>();
        this.payment = payment;
        this.countOfLottos = payment / PAYMENT_UNIT_VALUE.getValue();
        this.results = new ArrayList<>();
    }

    public static Customer createCustomer(int payment) {
        return new Customer(payment);
    }

    public int getCountOfLottos() {
        return this.countOfLottos;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public int getPayment() {
        return this.payment;
    }

    public void buyLottos() {
        for (int i = 0; i < this.countOfLottos; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            this.lottos.add(Lotto.createLotto(lottoNumbers));
        }
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<String> getInfoOfLottos() {
        return this.lottos.stream()
                .map(lotto -> lotto.getInfoOfNumbers())
                .collect(Collectors.toList());
    }

    public void calculateResult(Target target) {
        for (Lotto lotto : lottos) {
            Result result = lotto.compareWithTargetAndCreateResult(target);
            results.add(result);
        }
    }

}
