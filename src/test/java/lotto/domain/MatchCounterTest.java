package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.dto.MatchCountDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchCounterTest {
    private MatchCounter matchCounter;

    @BeforeEach
    void setAnswerNumbers() {
        List<Integer> answerNumbers = List.of(2, 4, 6, 8, 10, 12);
        matchCounter = MatchCounter.from(answerNumbers);
    }

    @DisplayName("[검증]MatchCounter_불변성__최초_입력된_정답은_수정할_수_없다")
    @Test
    void unModifiableAnswerNumbersTest() {
        // modifiable List가 MatchCounter의 answerNumbers 필드로 존재할 가능성을 막아야 한다.
        List<Integer> answerNubmers = Arrays.asList(11, 23, 24, 1, 7, 8); // modifiable list
        MatchCounter matchCounter = MatchCounter.from(answerNubmers);

        Lotto myLotto = Lotto.from(List.of(45, 44, 43, 42, 41, 40)); // 번호 일치 0개
        // 악의적 조작: 번호 일치 5개를 의도
        answerNubmers.set(0, 45);
        answerNubmers.set(1, 44);
        answerNubmers.set(2, 43);
        answerNubmers.set(3, 42);
        answerNubmers.set(4, 41);

        // 악의적 정답 조작에 영향받지 않아야 한다.
        Assertions.assertThat(matchCounter.countNumberMatch(myLotto.getNumbers())).isEqualTo(0);
    }

    @DisplayName("[예외]MatchCounter_보너스숫자__정답과 중복되면 안된다")
    @Test
    void setBonusNumber() {
        Assertions.assertThatThrownBy(() -> matchCounter.setBonusNumber(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NUMBER_DUPLICATED.get());
    }

    @DisplayName("[기능]MatchCounter_매칭세기__보너스 일치개수를 센다")
    @Test
    void countBonusMatch() {
        List<Integer> bonusNumbers = List.of(19, 11);
        List<Integer> correctReturns = List.of(0, 1);
        List<Integer> myNumber = List.of(1, 2, 7, 9, 11, 12);

        int testCase = correctReturns.size();
        for (int test = 0; test < testCase; test++){
            matchCounter.setBonusNumber(bonusNumbers.get(test));
            int bonusCount = matchCounter.countBonusMatch(myNumber);
            assertThat(bonusCount).isEqualTo(correctReturns.get(test));
        }
    }

    @DisplayName("[기능]MatchCounter_매칭세기__숫자 일치 개수를 센다")
    @Test
    void countNumberMatch() {
        List<Integer> myNumber = List.of(1, 2, 7, 9, 11, 12);
        assertThat(matchCounter.countNumberMatch(myNumber))
                .isEqualTo(2);
    }

    @DisplayName("[기능]MatchCounter_매칭세기__숫자 순서가 달라도 상관없이 개수를 센다")
    @Test
    void countUnsameNumbersOrder() {
        List<Integer> myLotto = List.of(12, 10, 8, 1, 2, 3);

        int counting = matchCounter.countNumberMatch(myLotto);
        assertThat(counting).isEqualTo(4);
    }

    @DisplayName("[기능]MatchCounter_매칭세기__보너스 및 숫자 일치 개수 센다")
    @Test
    void getMatchCounts() {
        matchCounter.setBonusNumber(7);
        LottoPaper lottoPaper = LottoPaper.create();
        lottoPaper.add(Lotto.from(List.of(1, 2, 7, 9, 11, 12)));  //2, 1
        lottoPaper.add(Lotto.from(List.of(3, 7, 10, 9, 11, 17)));  // 1, 1
        lottoPaper.add(Lotto.from(List.of(1, 3, 4, 5, 25, 27)));  // 1, 0
        lottoPaper.add(Lotto.from(List.of(13, 15, 7, 26, 33, 41))); // 0, 1

        List<MatchCountDto> expected = List.of(new MatchCountDto(2, 1),
                new MatchCountDto(1, 1),
                new MatchCountDto(1, 0),
                new MatchCountDto(0, 1)
        );

        List<MatchCountDto> matchCounts = matchCounter.getMatchCounts(lottoPaper);
        assertThat(matchCounts.toString()).isEqualTo(expected.toString());
    }
}