package lotto.lottosystem.bussiness;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class WoowahanLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
