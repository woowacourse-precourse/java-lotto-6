package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constant.LottoValue.*;

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
//            numbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        printLottos();
        return lottos;
    }

    public void printLottos(){
        System.out.println();
        System.out.println(lottoNumber+"개를 구매했습니다.");
//        lottos = lottos.stream()
//                .sorted()
//                .collect(Collectors.toList());
        for (int i = 0; i < lottoNumber; i++) {
            lottos.get(i).printLotto();
        }
    }
}
