package lotto.service;

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
import lotto.data.Lotto;
import lotto.data.UserLotto;
import lotto.io.input.LottoInput;
import lotto.io.input.MoneyInput;
import lotto.io.output.LottoOutput;
import lotto.meta.Result;

public class LottoService {
    private List<UserLotto> userLottos;
    private Map<Result, Integer> resultCounts;
    private Lotto lotto;
    private int bonusNumber;
    private int spendMoney;
    private int lottoCnt;

    public LottoService() {
        userLottos = new ArrayList<>();
        resultCounts = new LinkedHashMap<>();
        resultCounts.put(THREE, 0);
        resultCounts.put(FOUR, 0);
        resultCounts.put(FIVE, 0);
        resultCounts.put(FIVE_BONUS, 0);
        resultCounts.put(SIX, 0);
    }

    public void start() {
        getSpendMoney();
        getUserLottos(lottoCnt);
        getLottoNumber();
        getBonusNumber();
        compareNumbers();
        getResult();
    }

    private void getSpendMoney() {
        LottoOutput.printInputMoney();
        spendMoney = MoneyInput.getMoney();
        lottoCnt = spendMoney / 1000;
        LottoOutput.printNewLine();
    }

    private void getUserLottos(int cnt) {
        LottoOutput.printConfirmMoney(cnt);
        while (cnt-- > 0) {
            userLottos.add(new UserLotto(LottoInput.getRandomLotto()));
        }
        LottoOutput.printUserLottos(userLottos);
    }

    private void getLottoNumber() {
        LottoOutput.printInputLottoNumber();
        lotto = new Lotto(LottoInput.getLottoNumbers());
        LottoOutput.printNewLine();
    }

    private void getBonusNumber() {
        LottoOutput.printInputBonusNumber();
        bonusNumber = LottoInput.getBonusLottoNumber(lotto.getNumbers());
    }

    private void compareNumbers() {
        userLottos.forEach(userLotto -> {
            userLotto.compareNumber(lotto);
            if (userLotto.getCorrectCnt() != 6) {
                userLotto.compareBonus(bonusNumber);
            }
        });
        LottoOutput.printNewLine();
    }

    private void getResult() {
        LottoOutput.printGetResult();
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
