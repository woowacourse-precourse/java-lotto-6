package lotto.buyer;

import camp.nextstep.edu.missionutils.Console;
import lotto.company.LotteryResult;
import lotto.company.Lotto;
import lotto.company.LottoCompany;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest {

    private static ByteArrayOutputStream outputMessage;

    void provideRemoteInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();
    }

    String getOutput() {
        return outputMessage.toString();
    }

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("로또 구매 금액을 입력 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 로또_구매금액_입력(int expectedValue) throws Exception {
        //given
        Buyer buyer = new Buyer();
        provideRemoteInput(String.valueOf(expectedValue));

        //when
        int buyAmount = buyer.payForLotto();

        //then
        assertThat(buyAmount).isEqualTo(expectedValue);
    }

    @DisplayName("로또 구매 금액 예외처리 - 숫자가 아닌 경우 예외 발생")
    @Test
    void 로또_구매금액_입력_예외처리_숫자가_아닌_경우() throws Exception {
        //given
        Buyer buyer = new Buyer();
        String expectedValue = "난문자";
        provideRemoteInput(expectedValue);

        //when & then
        assertThatThrownBy(() -> buyer.payForLotto())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("로또 구매 금액 예외처리 - 1000의 배수가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 1200, 2600})
    void 로또_구매금액_입력_예외처리_1000의_배수가_아닌_경우(int expectedValue) throws Exception {
        //given
        Buyer buyer = new Buyer();
        provideRemoteInput(String.valueOf(expectedValue));

        //when & then
        assertThatThrownBy(() -> buyer.payForLotto())
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교")
    @Test
    void 구매한_로또_번호와_당첨_번호_비교() throws Exception {
        //given
        LottoCompany lottoCompany = new LottoCompany();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,6,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,7,8)));
        lottos.add(new Lotto(List.of(1,2,3,4,8,9)));
        lottos.add(new Lotto(List.of(1,2,3,8,9,10)));
        lottos.add(new Lotto(List.of(1,2,7,9,10,11)));

        Lotto lottery = new Lotto(List.of(1,2,3,4,5,6));
        LotteryResult lotteryResult = LotteryResult.from(lottery, 7);
        lottoCompany.addLotteryResult(lotteryResult);

        //when
        Buyer buyer = new Buyer();
        buyer.receiveLottos(lottos);
        Map<Integer, Integer> result = buyer.compareWithLotteryResult(lotteryResult);

        //then
        assertThat(result.get(1)).isEqualTo(1);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);
        assertThat(result.get(5)).isEqualTo(2);
    }

    @DisplayName("당첨 내역 출력")
    @Test
    void 당첨_내역_출력() throws Exception {
        //given
        LottoCompany lottoCompany = new LottoCompany();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,6,7)));
        lottos.add(new Lotto(List.of(1,2,3,4,7,8)));
        lottos.add(new Lotto(List.of(1,2,3,4,8,9)));
        lottos.add(new Lotto(List.of(1,2,3,8,9,10)));
        lottos.add(new Lotto(List.of(1,2,7,9,10,11)));

        Lotto lottery = new Lotto(List.of(1,2,3,4,5,6));
        LotteryResult lotteryResult = LotteryResult.from(lottery, 7);
        lottoCompany.addLotteryResult(lotteryResult);
        Buyer buyer = new Buyer();
        buyer.receiveLottos(lottos);
        Map<Integer, Integer> result = buyer.compareWithLotteryResult(lotteryResult);

        //when
        buyer.printLotteryResult();

        //then
        assertThat(getOutput())
                .contains(
                        "3개 일치 (5,000원) - 2개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 1개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                        "6개 일치 (2,000,000,000원) - 1개"
                );
    }

    @DisplayName("수익률 출력")
    @Test
    void 수익률_출력() throws Exception {
        //given
        LottoCompany lottoCompany = new LottoCompany();
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        Lotto lottery = new Lotto(List.of(1,2,3,4,5,6));
        LotteryResult lotteryResult = LotteryResult.from(lottery, 7);
        lottoCompany.addLotteryResult(lotteryResult);
        Buyer buyer = new Buyer();
        buyer.receiveLottos(lottos);
        Map<Integer, Integer> result = buyer.compareWithLotteryResult(lotteryResult);

        //when
        buyer.printLotteryResult();

        //then
        assertThat(getOutput()).contains(
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다."
        );
    }

}