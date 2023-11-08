package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.ExceptionMessages;
import lotto.enums.LottoPrize;
import lotto.enums.Patterns;

public class User {
    private final static Integer LOTTO_MAX = 45;
    private final static Integer LOTTO_MIN = 1;
    private final static Integer AMOUNT_UNIT = 1000;
    private Integer lottoTicketCount;
    private List<Lotto> lottos;
    private Map<LottoPrize, Integer> lottoResult;
    private Integer amount;
    private Double profitability;

    public User(String amount) {
        validateAmount(amount);
        this.amount = Integer.valueOf(amount);
        this.lottoTicketCount = this.amount / AMOUNT_UNIT;
        this.lottos = generateRandomLottos();
        initializeResultCounts();
    }

    private void initializeResultCounts() {
        this.lottoResult = new LinkedHashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            this.lottoResult.put(prize, 0);
        }
    }

    private void validateAmount(String amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_AMOUNT_MESSAGE.getMessage());
        }
    }

    private Boolean isValidAmount(String amount) {
        return Patterns.AMOUNT_CHECK_PATTERN.getPattern().matcher(amount).matches();
    }

    private List<Lotto> generateRandomLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < this.lottoTicketCount; count++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, 6)));
        }
        return lottos;
    }

    public void saveLottoRankResult(Lotto winningLotto, Integer bonusNumber) {
        this.lottos.stream().forEach(lotto -> {
            LottoPrize prize = lotto.getLottoRank(winningLotto, bonusNumber);
            this.lottoResult.put(prize, lottoResult.get(prize) + 1);
        });
    }

    public void calculateProfitability() {
        double totalPrize = 0;
        for (LottoPrize lottoPrize : this.lottoResult.keySet()) {
            totalPrize += lottoPrize.getPrizeAmount() * this.lottoResult.get(lottoPrize);
        }
        BigDecimal profit = new BigDecimal(totalPrize / this.amount).setScale(3, RoundingMode.HALF_UP);
        this.profitability = profit.doubleValue() * 100;
    }

    public Integer getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoPrize, Integer> getLottoResult() {
        return lottoResult;
    }

    public Double getProfitability() {
        return this.profitability;
    }
}
