package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        this.lottoTicketCount = Integer.valueOf(amount) / AMOUNT_UNIT;
        initializeResultCounts();
    }

    private void initializeResultCounts() {
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
        this.profitability = Math.round(((this.amount / totalPrize) * 100)) / 100.0;
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
}
