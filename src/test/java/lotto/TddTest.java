package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.util.RandomNumbers;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TddTest {

    @Test
    public void 로또는_한장에_천원() {
        LottoController lottoController = new LottoController();
        int lottoCount = lottoController.calculateLottoCount(8000);

        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    public void 로또_구매입력이_1000원_단위가_아닐때() {
        LottoController lottoController = new LottoController();

        int money = 1500;
        assertThatThrownBy(() -> {
            lottoController.calculateLottoCount(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 1000원 단위만 구매할 수 있습니다.");
    }

    @Test
    public void _1부터_45사이_로또번호_생성_테스트() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();

        for (int number : numbers) {
                assertThat(number).isBetween(1, 45);
        }
    }
    @Test
    public void 로또_번호는_6자리() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();
        Assertions.assertThat(numbers).hasSize(6);
    }

    @Test
    public void 로또_번호_5자리_오류() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();

        assertThrows(AssertionError.class, () -> {
            assertThat(numbers.size()).isEqualTo(5);
        });
    }

    @Test
    public void 당첨번호는_반점_기준으로_6자리_입력(){
        List<Integer> expectedWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> WinningNumbers = parseNumbers("1,2,3,4,5,6");
        assertThat(WinningNumbers).isEqualTo(expectedWinningNumbers);
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }





}
