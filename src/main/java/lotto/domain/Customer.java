package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.WinningInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.SystemOption.PAYMENT_UNIT_VALUE;

public class Customer {
    private List<Lotto> lottos;
    private int payment;
    private int countOfLottos;
    private List<WinningInfo> winningInfos;

    public Customer(int payment) {
        this.lottos = new ArrayList<>();
        this.payment = payment;
        this.countOfLottos = payment / PAYMENT_UNIT_VALUE.getValue();
        this.winningInfos = new ArrayList<>();
    }

    public static Customer createCustomer(int payment) {
        return new Customer(payment);
    }

    public int getCountOfLottos() {
        return this.countOfLottos;
    }

    public List<WinningInfo> getWinningInfos() {
        return this.winningInfos;
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

    // 고객이 구매한 로또와 당첨번호(Target)를 비교하여 일치한 숫자 개수와 보너스 당첨 여부 정보를 가진 WinningInfo 생성
    public void calculateWinning(Target target) {
        for (Lotto lotto : lottos) {
            lotto.compareWithTargetAndCreateWinningInfo(target)
                    .ifPresent(winningInfo -> this.winningInfos.add(winningInfo));
        }
    }

}
