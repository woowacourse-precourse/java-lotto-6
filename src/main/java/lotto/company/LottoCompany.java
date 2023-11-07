package lotto.company;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCompany implements Company {

    @Override
    public List<Lotto> generateLottoList(int buyAmount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = buyAmount; i > 0; i -= 1000) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            result.add(lotto);
        }
        return result;
    }

    @Override
    public void printLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        lottoList.stream()
                .map(lotto -> lotto.getNumbers())
                .forEach(numbers -> {
                    Collections.sort(numbers);
                    System.out.println(numbers);
                });
    }
}
