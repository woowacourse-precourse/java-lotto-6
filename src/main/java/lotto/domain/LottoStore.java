package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
    private static final int PRICE = 1000;

    private final List<Lotto> lottoes;
    private final int totalLottoNumber;

    public LottoStore(Amount amount) {
        this.totalLottoNumber = amount.getAmount() / PRICE;
        this.lottoes = publishLottoes(this.totalLottoNumber);
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }

    public int getTotalLottoNumber() {
        return this.totalLottoNumber;
    }

    private Lotto publishLotto() {
        return new Lotto(getRandomNumbers());
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }

    private List<Lotto> publishLottoes(int totalLottoes) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < totalLottoes; i++) {
            lottoes.add(publishLotto());
        }
        return lottoes;
    }


}
