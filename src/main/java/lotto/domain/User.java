package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumber;
import lotto.util.RankUtil;

public class User {
    private static final int LOTTO_PRICE = Constant.LOTTO_PRICE;
    private static final int MONEY_THRESHOLD = Constant.MONEY_THRESHOLD;
    private final List<Lotto> lottos = new ArrayList<>();
    private final long money;

    public User(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        validatePositive(money);
        validateMoneyDivisible(money);
        validateMinimumMoney(money);
    }

    private void validatePositive(long money) {
        final String message = "금액은 음수일 수 없습니다.";
        if (money < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateMoneyDivisible(long money) {
        final String message = "금액은 %d원 단위여야 합니다.";
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(message, LOTTO_PRICE));
        }
    }

    private void validateMinimumMoney(long money) {
        final String message = "금액은 %d원 이상이어야 합니다.";
        if (money < MONEY_THRESHOLD) {
            throw new IllegalArgumentException(String.format(message, MONEY_THRESHOLD));
        }
    }

    public void buyLotto() {
        final long lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = RandomNumber.generateLotteryNumber();
            lottos.add(new Lotto(numbers));
        }
        printMyLotto();
    }

    private void printMyLotto() {
        final String message = "%d개를 구매했습니다.";
        validateLottoListNotEmpty();
        System.out.println(String.format(message, lottos.size()));
        lottos.forEach(Lotto::printNumbers);
    }

    public void doDraw(Draw draw) {
        final String message = "추첨 정보를 입력하세요.";
        if (draw == null) {
            throw new IllegalArgumentException(message);
        }
        validateLottoListNotEmpty();
        final List<Rank> ranks = draw.doDraw(lottos);
        printDrawResult(ranks);
        printProfitRate(ranks);
    }

    private void printDrawResult(List<Rank> ranks) {
        validateLottoListNotEmpty();
        System.out.println("당첨 통계");
        System.out.println("---");
        RankUtil.printResult(ranks);
    }

    private void printProfitRate(List<Rank> ranks) {
        final String message = "총 수익률은 %.1f%%입니다.";
        validateLottoListNotEmpty();
        final long profits = RankUtil.getProfits(ranks);
        System.out.println(String.format(message, (double) profits / money));
    }

    private void validateLottoListNotEmpty() {
        final String message = "로또를 먼저 구매해야 합니다.";
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
