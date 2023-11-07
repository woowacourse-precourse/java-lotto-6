package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.RandomNumbers;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
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
    @Test
    public void 로또_번호가_같은게_있으면_예외처리(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> new Lottos(lottoList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 중복되었습니다.");
    }

    @Test
    public void HashMap값_확인(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        lottoList.add(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)));

        Lottos lottos = new Lottos(lottoList);

        Map<Long,Long> testMap = lottos.checkWinningNumbers(Arrays.asList(2, 5, 9, 15, 18, 20), 7);
        for (Map.Entry<Long, Long> entry : testMap.entrySet()) {
            Long key = entry.getKey();
            Long value = entry.getValue();
            System.out.println("당첨 개수: " + key + ", 당첨 횟수: " + value);
        }
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }




}
