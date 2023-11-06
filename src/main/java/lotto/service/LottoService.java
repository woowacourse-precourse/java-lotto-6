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
        System.out.println("구입금액을 입력해 주세요.");
        spendMoney = MoneyInput.getMoney();
        lottoCnt = spendMoney / 1000;
    }

    private void getUserLottos(int cnt) {
        System.out.println("\n" + cnt + "개를 구매했습니다.");
        while (cnt-- > 0) {
            userLottos.add(new UserLotto(LottoInput.getRandomLotto()));
        }

        userLottos.forEach(userLotto -> {
            System.out.println(userLotto.toString());
        });
        System.out.println();
    }

    private void getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        lotto = new Lotto(LottoInput.getLottoNumbers());
        System.out.println();
    }

    private void getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = LottoInput.getBonusLottoNumber(lotto.getNumbers());
    }

    private void compareNumbers() {
        userLottos.forEach(userLotto -> {
            userLotto.compareNumber(lotto);
            if (userLotto.getCorrectCnt() != 6) {
                userLotto.compareBonus(bonusNumber);
            }
        });
    }

    private void getResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        double sum = 0.0;
        for (UserLotto userLotto : userLottos) {
            Result result = Result.getResult(userLotto.getCorrectCnt(), userLotto.getBonusCnt());
            if (ETC.equals(result)) {
                continue;
            }

            sum += result.getSumMoney();

            resultCounts.put(result, resultCounts.get(result) + 1);
        }

        for (Map.Entry<Result, Integer> entry : resultCounts.entrySet()) {
            System.out.println(entry.getKey().getText() + " - " + entry.getValue() + "개");
        }

        System.out.println("총 수익은 " + sum * 100.0 / (double) spendMoney + "% 입니다.");
    }
}
