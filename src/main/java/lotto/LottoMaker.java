package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Lotto> getLottoAsMuchAsVolume(int volume) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < volume; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(getLottoNumbers());
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            allLotto.add(lotto);
        }
        System.out.println(volume+"개를 구매했습니다.");
        return allLotto;
    }

    public void getAllLottoAsConsole(List<Lotto> allLotto){
        for(Lotto lotto : allLotto){
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
