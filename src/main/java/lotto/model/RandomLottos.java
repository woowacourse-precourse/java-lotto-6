package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.Numbers.LOTTONUMBEREND;
import static lotto.constant.Numbers.LOTTONUMBERSTART;
import static lotto.constant.Numbers.LOTTOPRICE;
import static lotto.constant.Numbers.NUMBERSPERLOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomLottos {
    private final List<Lotto> randomLottos;
    private final Integer lottoTicketNumber;

    public RandomLottos(LottoAmountofMoney lottoAmountofMoney) {
        this.lottoTicketNumber = lottoAmountofMoney.getLottoAmountofMoney() / LOTTOPRICE.getIntValue();
        this.randomLottos = generateRandomLottos();
    }

    private List<Lotto> generateRandomLottos() {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketNumber; i++) {
            randomLottos.add(generateLotto());
        }
        return randomLottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = pickUniqueNumbersInRange(LOTTONUMBERSTART.getIntValue(), LOTTONUMBEREND.getIntValue(),
                NUMBERSPERLOTTO.getIntValue());
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        System.out.println(lottoNumbers.toString());
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }
}
