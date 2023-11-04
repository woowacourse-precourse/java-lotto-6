package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.SystemOption.*;
import static lotto.message.GuideMessage.SHOW_LOTTOS_INFO_MESSAGE;

public class Customer {

    private List<Lotto> lottos;
    private int payment;
    private int prize;
    private int numberOfLottos;

    public Customer(int payment) {
        this.lottos = new ArrayList<>();
        this.payment = payment;
        this.prize = 0;
        this.numberOfLottos = payment / PAYMENT_UNIT_VALUE.getValue();
    }


    public static Customer createCustomer(int payment) {
        return new Customer(payment);
    }

    public void buyLottos() {
        for (int i = 0; i < this.numberOfLottos; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            Lotto lotto = Lotto.createLotto(lottoNumbers);
            this.lottos.add(lotto);
        }
    }

    private static List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    public void printInfoOfLottos() {
        System.out.println(String.format(SHOW_LOTTOS_INFO_MESSAGE.toString(), this.numberOfLottos));
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }
}
