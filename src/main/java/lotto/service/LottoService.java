package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.NumberGenerator;

/*
 * @author 강병관
 *
 * 로또를 만드는 과정에 필요한 메소드에 관여
 */
public class LottoService {
    private Integer money;
    private Integer count;
    private List<Lotto> lottos;
    private List<Integer> winNumbers;
    private Integer bonusNumber;
    private static NumberGenerator numberGenerator;
    private static final Integer threshold = 1000;
    private static final String MONEY_NOT_DIVIDED_BY_THOUSAND = "[ERROR] 거스름돈을 만들어선 안 됩니다. (개당 1,000원)";
    private static final String WINNING_NUMBERS_NOT_SIX = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String WINNING_NUMBER_BETWEEN_ONE_AND_FOURTY_FIVE = "[ERROR] 당첨 번호는 1부터 45 사이여야 합니다";
    private static final String WINNING_NUMBER_IS_UNIQUE = "[ERROR] 당첨 번호는 겹쳐서는 안 됩니다.";

    public LottoService() {
        lottos = new ArrayList<>();
        winNumbers = new ArrayList<>();
        numberGenerator = NumberGenerator.getInstance();
        money = 0;
        count = 0;
        bonusNumber = -1;
    }

    public void setMoney(Integer money) {
        if (money % threshold != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_THOUSAND);
        }
        this.money = money;
        this.count = money / threshold;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_SIX);
        }
        for (Integer number : winNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(WINNING_NUMBER_BETWEEN_ONE_AND_FOURTY_FIVE);
            }
            if (Collections.frequency(winNumbers, number) > 1) {
                throw new IllegalArgumentException(WINNING_NUMBER_IS_UNIQUE);
            }
        }
        this.winNumbers = winNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_UNIQUE);
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(WINNING_NUMBER_BETWEEN_ONE_AND_FOURTY_FIVE);
        }
        this.bonusNumber = bonusNumber;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

    public List<Lotto> createLottos() {
        for (int i=0; i<count; i++) {
            List<Integer> numbers = numberGenerator.createRandom6Numbers(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<LottoEnum> compareLottos() {
        List<LottoEnum> rankings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            rankings.add(lotto.getRanking(winNumbers, bonusNumber));
        }
        return rankings;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer calcTotalWinningMoney() {
        Integer totalWinningMoney = 0;
        for (Lotto lotto : lottos) {
            totalWinningMoney += lotto.getRanking(winNumbers, bonusNumber).getWinningMoney();
        }
        return totalWinningMoney;
    }
}
