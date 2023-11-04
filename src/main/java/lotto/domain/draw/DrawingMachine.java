package lotto.domain.draw;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Money;

public class DrawingMachine {
    private static final int LOTTO_PRICE = 1_000;
    private final NumbersGenerator numbersGenerator;

    public DrawingMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos drawLottoTicketsWithGivenMoney(Money currentMoney) {
        Money remainingMoney = currentMoney;
        if (remainingMoney.getMoney() < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또를 더 이상 발행할 수 없습니다.");
        }
        List<Lotto> purchasedLottoTickets = generateLottoTickets(remainingMoney);
        return new Lottos(purchasedLottoTickets);
    }

    private List<Lotto> generateLottoTickets(Money remainingMoney) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (remainingMoney.getMoney() >= LOTTO_PRICE) {
            Lotto lotto = createLottoTickets();
            lottoTickets.add(lotto);
            remainingMoney = remainingMoney.decremented();
        }
        return lottoTickets;
    }

    // ref
    private Lotto createLottoTickets() {
        List<Integer> numbers = numbersGenerator.generate();
        return Lotto.from(numbers);
        // return new Lotto(numbers); fix. Lotto의 생성자가 default로 선언되었기 때문에 외부에서 선언 불가
    }
}
