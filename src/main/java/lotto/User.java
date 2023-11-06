package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Draw;
import lotto.lotto.Lotto;
import lotto.lotto.Rank;
import lotto.util.RandomNumber;
import lotto.util.RankUtil;

public class User {
    private static final int MONEY_THRESHOLD = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;
    private final long money;

    public User(long money) {
        lottoList = buyLotto(money);
        this.money = money;
    }

    public List<Lotto> buyLotto(long money) {
        List<Lotto> lottoList = new ArrayList<>();
        validateMoney(money);
        final long lottoCount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = RandomNumber.generateLotteryNumber();
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public void printMyLotto() {
        final String message = "%d개를 구매했습니다.";
        validateLottoListNotEmpty();
        System.out.println(String.format(message, lottoList.size()));
        lottoList.forEach(Lotto::printNumbers);
    }

    public void doDraw(Draw draw) {
        if (draw == null) {
            throw new IllegalArgumentException("추첨 정보를 입력하세요.");
        }
        validateLottoListNotEmpty();
        final List<Rank> ranks = draw.doDraw(lottoList);
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
        validateLottoListNotEmpty();
        final long profits = RankUtil.getProfits(ranks);
        final String message = "총 수익률은 %.2f%%입니다.";
        System.out.println(String.format(message, (double) profits / money));
    }


    private void validateMoney(long money) {
        validateMinimumMoney(money);
        validateMoneyDivisible(money);
    }

    private void validateMinimumMoney(long money) {
        final String message = "로또 구입 금액은 %s원 이상이어야 합니다.";
        if (money < MONEY_THRESHOLD) {
            throw new IllegalArgumentException(String.format(message, MONEY_THRESHOLD));
        }
    }

    private void validateMoneyDivisible(long money) {
        final String message = "로또 구입 금액은 1000원 단위여야 합니다.";
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateLottoListNotEmpty() {
        final String message = "로또를 먼저 구매해야 합니다.";
        if (lottoList == null || lottoList.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
