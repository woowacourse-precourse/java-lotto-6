package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lotto.enums.ExceptionMessages;
import lotto.enums.Patterns;

public class User {
    private final static Integer LOTTO_MAX = 45;
    private final static Integer LOTTO_MIN = 1;
    private final static Integer AMOUNT_UNIT = 1000;
    private Integer lottoTicketCount;
    private List<Lotto> lottos;
    private List<Integer> result;

    public User(String amount) {
        validateAmount(amount);
        this.lottoTicketCount = Integer.valueOf(amount) / AMOUNT_UNIT;
        this.lottos = this.generateRandomLottos();
        this.result = new ArrayList<>(Collections.nCopies(6, 0));
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
            int rank;
            rank = lotto.getLottoRank(winningLotto, bonusNumber);
            this.result.set(rank, this.result.get(rank) + 1);
        });
    }

    public Integer getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getResult() {
        return result;
    }
}
