package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LottoListTest {
    public static WinningNumbers winningNumbers;
    public static LottoList lottoList;
    public static List<Lotto> lottos;
    public static LottoResultMap lottoResultMap;

    @BeforeAll
    static void setup() {
        lottos = new ArrayList<>();

        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(1, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        Map<LottoResult, Integer> lottoResultIntegerMap = new HashMap<>();

        lottoResultIntegerMap.put(LottoResult.FIRST, 1);
        lottoResultIntegerMap.put(LottoResult.SECOND, 1);
        lottoResultIntegerMap.put(LottoResult.THIRD, 1);
        lottoResultIntegerMap.put(LottoResult.FIFTH, 1);
        lottoResultIntegerMap.put(LottoResult.NONE, 2);

        lottoResultMap = new LottoResultMap(lottoResultIntegerMap);


        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("LottoList 생성 테스트")
    @Test
    void createLottoList() {
        Assertions.assertThatCode(() -> new LottoList(lottos)).doesNotThrowAnyException();
    }

    @DisplayName("LottoList 결과값 반환 테스트")
    @Test
    void getLottoResult() {
        lottoList = new LottoList(lottos);
        Assertions.assertThat(lottoList.getLottoResult(winningNumbers))
                .isEqualTo(lottoResultMap);
    }
}