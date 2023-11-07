package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Validations;

import java.math.BigDecimal;
import java.util.*;

import static lotto.utils.Constants.*;

public class LottoBuySystem {
    private Lotto[] lottos;

    public LottoBuySystem() {}

    public void validatePrice(String givenPrice) {
        Validations.checkNumber(givenPrice);
        Validations.checkDivideByLottoPrice(Integer.parseInt(givenPrice), LOTTO_PRICE);
    }

    public void buyLottos(String givenPrice) {
        BigDecimal price = new BigDecimal(givenPrice);
        BigDecimal _lottoCount = price.divide(new BigDecimal(LOTTO_PRICE));
        int lottoCount = _lottoCount.intValue();

        this.lottos = new Lotto[lottoCount];
        for(int i=0; i<lottoCount; i++) {
            lottos[i] = new Lotto(this.generateLottoNumbers());
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_UNDER_BOUND, LOTTO_UPPER_BOUND, LOTTO_DRAW_NUMBER_COUNT
        );
//        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public int[][] getLottosNumbers() {
        int lottosCount = this.getLottosCount();
        int[][] lottoNumbers = new int[lottosCount][LOTTO_DRAW_NUMBER_COUNT + LOTTO_DRAW_BONUS_NUMBER_COUNT];

        for(int i=0; i<lottosCount; i++) {
            lottoNumbers[i] = this.lottos[i].getNumbers().stream().mapToInt(n -> n).toArray();
        }

        return lottoNumbers;
    }

    public int getLottosCount() {
        return this.lottos.length;
    }


}
