package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.ExceptionHandling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoTicketStore {
    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public LottoTicketStore(int purchaseAmount) {
        this.lottos = buyLotto(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }


    private List<Lotto> buyLotto(int purchaseAmount) {
        return IntStream.range(0, getLottoCount(purchaseAmount))
                .mapToObj(i -> new Lotto(generateLotto()))
                .collect(Collectors.toList());
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / ExceptionHandling.LOTTO_PRICE;
    }

    private List<Integer> generateLotto() {
        List<Integer> numbers = generateRandomNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(numbers); // 새로운 리스트를 생성하여 복사
        Collections.sort(sortedNumbers);
        try {
            Lotto lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            generateLotto();
        }
        return sortedNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(ExceptionHandling.MIN_NUMBER, ExceptionHandling.MAX_NUMBER, 6);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {

        return purchaseAmount;
    }


}
