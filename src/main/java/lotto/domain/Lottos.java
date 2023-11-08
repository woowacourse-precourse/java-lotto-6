package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import lotto.dto.request.AnswerNumberRequestDto;
import lotto.dto.response.LottosResponseDto;
import lotto.util.Rank;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int LottoCount = money / Lotto.PRICE;

        for (int buyCount = 0; buyCount < LottoCount; buyCount++) {
            lottos.add(new Lotto(randomNumbers()));
        }
        return new Lottos(lottos);
    }

    private static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.COUNT);
    }

    public LottosResponseDto toResponse() {
        return new LottosResponseDto(lottos);
    }

    public StatisticsMachine matchNumber(AnswerNumberRequestDto answerNumberRequestDto) {
        List<Rank> ranks = new ArrayList<>();
        lottos.forEach(lotto->ranks.add(lotto.result(answerNumberRequestDto.getLotto(),answerNumberRequestDto.getBonusNumber())));
        return new StatisticsMachine(ranks);
    }
}
