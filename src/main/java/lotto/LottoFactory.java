package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constant.LottoValue.*;
import static output.OutputMessage.OUTPUT_PURCHASE_AMOUNT;

public class LottoFactory {
    private int lottoNumber;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoFactory(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Lotto> createLottos(){
        for (int i = 0; i < lottoNumber; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER.value(), LOTTO_MAXIMUM_NUMBER.value(), LOTTO_SIZE.value()));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        printLottos();
        return lottos;
    }

    public void printLottos(){
        System.out.println();
        System.out.printf(OUTPUT_PURCHASE_AMOUNT.message(), lottoNumber);
        lottos.stream()
                .filter(lotto -> lotto!=null)
                .forEach(Lotto::printLotto);
    }

}
