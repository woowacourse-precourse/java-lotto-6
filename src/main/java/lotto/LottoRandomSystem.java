package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoRandomSystem {

    private List<List<Integer>> randomLottoNumbers = new ArrayList<>();

    public void generateLottoNumbers() {
        for (int i = 0; i < LottoPurchaseSystem.lottoAmount; i++) {
            this.randomLottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }


    public List<List<Integer>> getRandomLottoNumbers() {
        return randomLottoNumbers;
    }
}
