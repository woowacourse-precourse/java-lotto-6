package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.dto.response.LottoTicketsDto;
import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

@DisplayName("LottoMachine 클래스")
class LottoMachineTest {

    @Nested
    @DisplayName("LottoMachine 생성")
    class CreateLottoMachine {

        @ParameterizedTest
        @CsvSource({
                "1000, 1",
                "2000, 2",
                "5000, 5"
        })
        @DisplayName("유효한 금액으로 LottoMachine을 생성한다")
        void createWithValidMoney(int inputAmount, int expectedTicketCount) {
            // 준비
            Money money = Money.from(String.valueOf(inputAmount));
            NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();

            // 실행
            LottoMachine lottoMachine = LottoMachine.of(numberGenerator, money);

            // 검증
            LottoTicketsDto lottoTicketsDto = lottoMachine.createLottoTickets();
            assertAll(
                    () -> assertThat(lottoTicketsDto.getLottoCost()).isEqualTo(inputAmount),
                    () -> assertThat(lottoTicketsDto.getLottos().getLottoTickets().size())
                            .isEqualTo(expectedTicketCount)
            );
        }

        @Test
        @DisplayName("금액이 음수거나 로또 가격으로 나누어 떨어지지 않으면 예외를 던진다")
        void throwErrorWhenMoneyIsInvalid() {
            // 준비
            String invalidMoney = "-1000";
            NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();

            // 실행
            Throwable throwable = catchThrowableOfType(() ->
                    LottoMachine.of(numberGenerator, Money.from(invalidMoney)), IllegalArgumentException.class);

            // 검증
            assertThat(throwable).isNotNull()
                    .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT
                            .getFormattedMessage(LottoConfig.LOTTO_PRICE.getValue()));
        }
    }

    @Nested
    @DisplayName("LottoTickets 생성")
    class CreateLottoTickets {

        @Test
        @DisplayName("로또 티켓을 생성한다")
        void createLottoTicketsSuccessfully() {
            // 준비
            int amount = 3000;
            Money money = Money.from(String.valueOf(amount));
            NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();
            LottoMachine lottoMachine = LottoMachine.of(numberGenerator, money);

            // 실행
            LottoTicketsDto lottoTicketsDto = lottoMachine.createLottoTickets();

            // 검증
            assertThat(lottoTicketsDto.getLottos().getLottoTickets())
                    .hasSize(amount / LottoConfig.LOTTO_PRICE.getValue());
        }

        @Test
        @DisplayName("로또 번호의 개수가 6개가 아닐 경우 예외를 던진다")
        void throwErrorWhenLottoNumbersCountIsIncorrect() {
            // 준비
            Money money = Money.from("1000");
            NumberGenerator mockNumberGenerator = new NumberGenerator() {
                @Override
                public List<Integer> generate(int startInclusive, int endInclusive, int count) {
                    // 잘못된 개수의 번호를 생성하는 NumberGenerator 구현
                    return Arrays.asList(1, 2, 3, 4, 5); // 5개만 생성
                }
            };
            LottoMachine lottoMachine = LottoMachine.of(mockNumberGenerator, money);

            // 실행
            Throwable throwable = catchThrowableOfType(lottoMachine::createLottoTickets
                    , IllegalArgumentException.class);

            // 검증
            assertThat(throwable).isNotNull()
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    @DisplayName("Lotto 번호 유효성 테스트")
    class LottoNumberValidation {

        @Test
        @DisplayName("생성된 로또 번호가 지정된 범위 내에 있는지 확인한다")
        void shouldGenerateNumbersWithinRange() {
            // 준비
            Money money = Money.from("1000");
            NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();
            LottoMachine lottoMachine = LottoMachine.of(numberGenerator, money);

            // 실행
            LottoTicketsDto lottoTicketsDto = lottoMachine.createLottoTickets();
            List<Lotto> lottoTickets = lottoTicketsDto.getLottos().getLottoTickets();

            // 검증
            assertThat(lottoTickets)
                    .flatExtracting(Lotto::getNumbers)
                    .allMatch(number -> number >= LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                            && number <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
        }

        @Test
        @DisplayName("로또 번호가 중복되지 않는지 확인한다")
        void shouldGenerateUniqueNumbers() {
            // 준비
            Money money = Money.from("1000");
            NumberGenerator numberGenerator = new UniqueRandomNumbersGenerator();
            LottoMachine lottoMachine = LottoMachine.of(numberGenerator, money);

            // 실행
            LottoTicketsDto lottoTicketsDto = lottoMachine.createLottoTickets();
            List<Lotto> lottoTickets = lottoTicketsDto.getLottos().getLottoTickets();

            // 검증
            assertThat(lottoTickets)
                    .allSatisfy(lottoTicket -> assertThat(lottoTicket.getNumbers()).doesNotHaveDuplicates());
        }
    }
}