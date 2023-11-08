package lotto.data;

import static lotto.meta.Result.ETC;
import static lotto.meta.Result.FIVE;
import static lotto.meta.Result.FIVE_BONUS;
import static lotto.meta.Result.FOUR;
import static lotto.meta.Result.SIX;
import static lotto.meta.Result.THREE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.io.input.LottoInput;
import lotto.io.input.MoneyInput;
import lotto.io.output.LottoOutput;
import lotto.meta.Result;

public class LottoRepository {
    private List<UserLotto> userLottos;
    private Map<Result, Integer> resultCounts;
    private Lotto lotto;
    private int bonusNumber;
    private int spendMoney;

    public LottoRepository() {
        userLottos = new ArrayList<>();
        resultCounts = new LinkedHashMap<>();
        resultCounts.put(THREE, 0);
        resultCounts.put(FOUR, 0);
        resultCounts.put(FIVE, 0);
        resultCounts.put(FIVE_BONUS, 0);
        resultCounts.put(SIX, 0);
    }

    public LottoRepository(Lotto lotto, int bonusNumber, List<UserLotto> userLottos) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.userLottos = userLottos;
    }

    public int getSpendMoney() {
        while (true) {
            try {
                spendMoney = MoneyInput.getMoney();
                return spendMoney / 1000;
            } catch (IllegalArgumentException e) {
                LottoOutput.printErrorMessage(e);
            }
        }
    }

    public void getUserLottos(int cnt) {
        while (cnt-- > 0) {
            userLottos.add(new UserLotto(LottoInput.getRandomLotto()));
        }
        LottoOutput.printUserLottos(userLottos);
    }

    public void getLottoNumber() {
        while (true) {
            try {
                lotto = new Lotto(LottoInput.getLottoNumbers());
                return;
            } catch (IllegalArgumentException e) {
                LottoOutput.printErrorMessage(e);
            }
        }
    }

    public void getBonusNumber() {
        while (true) {
            try {
                bonusNumber = LottoInput.getBonusLottoNumber(lotto.getNumbers());
                return;
            } catch (IllegalArgumentException e) {
                LottoOutput.printErrorMessage(e);
            }
        }
    }

    public void compareNumbers() {
        userLottos.forEach(userLotto -> {
            userLotto.compareNumber(lotto);
            if (userLotto.getCorrectCnt() != 6) {
                userLotto.compareBonus(bonusNumber);
            }
        });
    }

    public void getResult() {
        double sum = 0.0;
        for (UserLotto userLotto : userLottos) {
            Result result = Result.getResult(userLotto.getCorrectCnt(), userLotto.getBonusCnt());
            if (ETC.equals(result)) {
                continue;
            }

            sum += result.getSumMoney();
            resultCounts.put(result, resultCounts.get(result) + 1);
        }
        LottoOutput.printResultCounting(resultCounts);
        LottoOutput.printTotalProfit(sum, spendMoney);
    }
}
