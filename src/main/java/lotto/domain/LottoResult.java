package lotto.domain;

import java.util.List;
import java.util.Optional;

public enum LottoResult {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    FIFTH("3개 일치 (5,000원)", 5_000),
    ;

    private final String message;
    private final int price;

    LottoResult(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    public static Optional<LottoResult> getLottoResult(WinningLotto winningLotto, Lotto userLotto) {
        List<Integer> winningNumbers = winningLotto.getLotto().getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();
        int lottoCount = getLottoCount(winningLotto.getLotto(), userLotto);
        boolean correctBonusNumber = false;

        if (userNumbers.contains(winningLotto.getBonusNumber())) {
            correctBonusNumber = true;
        }

        return findLottoResult(lottoCount, correctBonusNumber);
    }

    private static int getLottoCount(Lotto lotto1, Lotto lott2) {
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lott2.getNumbers();
        int lottoCount = 0;

        for (Integer number : numbers1) {
            if (numbers2.contains(number)) {
                lottoCount += 1;
            }
        }

        return lottoCount;
    }

    private static Optional<LottoResult> findLottoResult(int lottoCount, boolean correctBonusNumber) {
        if (lottoCount == 6) {
            return Optional.of(LottoResult.FIRST);
        } else if (lottoCount == 5 && correctBonusNumber) {
            return Optional.of(LottoResult.SECOND);
        } else if (lottoCount == 5) {
            return Optional.of(LottoResult.THIRD);
        } else if (lottoCount == 4) {
            return Optional.of(LottoResult.FOURTH);
        } else if (lottoCount == 3) {
            return Optional.of(LottoResult.FIFTH);
        }
        return Optional.empty();
    }


}
