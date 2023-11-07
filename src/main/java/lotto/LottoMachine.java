package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    // 구입한 개수만큼 로또를 생성한다
    public List<Lotto> createLotto(int lottoAmount) {
        List<Lotto> lottoNumbersList = new ArrayList<>();

        for (int i = 1; i <= lottoAmount; i++) {
            lottoNumbersList.add(new Lotto(createRandomLottoNumbers()));
        }
        return lottoNumbersList;
    }

    // 6개의 랜덤 숫자를 생성하고 오름차순으로 정렬한다
    public List<Integer> createRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        return numbers;
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto list : lottos) { //랜덤으로 생성된 로또 출력
            System.out.println(list.getNumbers());
        }
    }
}
