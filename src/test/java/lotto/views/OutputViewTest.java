package lotto.views;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView;
    LottoService lottoService;
    OutputStream captor;

    @BeforeEach
    protected final void init() {
        outputView = new OutputView();
        lottoService = new LottoService();
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 로또_개수_및_숫자_출력_테스트() {
        //given
        int lottoCount = 10;
        List<Lotto> publish = lottoService.publish(lottoCount);
        //when
        outputView.lottoQuantityAndNumber(publish);
        //then
        assertThat(output().contains(
                lottoCount+OutputView.PURCHASE_LOTTO_OUTPUT
        ));
    }

    @Test
    void 로또_숫자_출력용_문자열_병합_테스트(){
        //given
        CharSequence delimiter = ",";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        String expectedNumbers = "1, 2, 3, 4, 5, 6";

        //when
        String joinedNumbers = outputView.joinNumbers(delimiter, numbers);

        //then
        assertThat(joinedNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void 당첨_내역_출력_테스트(){
        //given
        Map<Prize, Integer> lotteryResult = new LinkedHashMap<>();
        lotteryResult.put(Prize.FIFTH_REWARD, 1);
        lotteryResult.put(Prize.FOURTH_REWARD, 2);
        lotteryResult.put(Prize.THIRD_REWARD, 3);
        lotteryResult.put(Prize.SECOND_REWARD, 4);
        lotteryResult.put(Prize.FIRST_REWARD, 5);

        //when
        outputView.winningRecord(lotteryResult);

        //then
        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 2개",
                "5개 일치 (1,500,000원) - 3개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개",
                "6개 일치 (2,000,000,000원) - 5개"
                );
    }

    @Test
    void 당첨_내역_출력용_문자열_병합_테스트(){
        //given
        Prize prize = Prize.THIRD_REWARD;
        int count = 3;
        String expect = prize.getMatchCount() + "개 일치 " + "(1,500,000원) - "+ count + "개\n";

        //when
        String result = outputView.joinPrize(prize, count);

        //then
        assertThat(result).isEqualTo(expect).isEqualTo(result);
    }

    @Test
    void 당첨_내역_2등_확인_테스트(){
        //given
        Prize second = Prize.SECOND_REWARD;
        String expect = ", 보너스 볼 일치 (";

        //when
        String result = outputView.checkSecondPrize(second);

        //then
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void 당첨_내역_2등_확인_테스트_2등_아닌_경우(){
        //given
        Prize third = Prize.THIRD_REWARD;
        String expect = " (";

        //when
        String result = outputView.checkSecondPrize(third);

        //then
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void 수익률_출력_테스트(){
        //given
        double rewardRatio = 12.123456;

        //when
        outputView.rewardRatioRecord(rewardRatio);

        //then
        assertThat(output()).contains("12.12");
    }
}
