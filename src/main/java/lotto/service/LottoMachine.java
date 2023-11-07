package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Coin;
import lotto.model.Lotto;
import lotto.model.LottoPaper;

public class LottoMachine {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT_NUMBER = 6;
    private List<Lotto> lottos;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }


    public List<LottoPaper> publishLottoPaper(Coin coin) {

        for(int i = 0; i < coin.getCount(); i++) {
            generateLotto();
        }

        return lottos.stream()
                .map(lotto -> new LottoPaper(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private void generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER,
                MAX_NUMBER,
                COUNT_NUMBER);

        lottos.add(new Lotto(numbers));
    }


}
