package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

// TODO: 로또 생성 전략을 Interface로
public class PurchaseComputer {
    private static PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();

    // TODO: 1000원 단위가 아닌경우, INPUTVIEW에서 예외처리

    public int getCountOfPurchasable(int amount) {
        return amount / 1000;
    }

    public void purchaseLottoForCount(int count) {
        for (int i = 0; i < count; i++) {
            purchaseEachLotto();
        }
    }

    private void purchaseEachLotto() {
        Lotto lottoTicket = new Lotto(generateLottoNumbers());
        purchaseRepository.recordPurchase(lottoTicket);
    }

    private List<Integer> generateLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new ArrayList<>(numbers);
    }
}
