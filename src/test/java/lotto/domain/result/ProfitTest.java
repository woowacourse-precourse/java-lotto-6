package lotto.domain.result;

class ProfitTest {

//    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//    @BeforeEach
//    void setUp() {
//        System.setOut(new PrintStream(outputStreamCaptor));
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.setOut(System.out);
//    }
//
//    @Test
//    void 수익률을_조회한다() {
//        // Arrange
//        int purchaseCount = 5;
//
//        Statistics statistics = Statistics.of();
//        statistics.apply(FIRST);
//        statistics.apply(SECOND);
//        statistics.apply(THIRD);
//        statistics.apply(FOURTH);
//        statistics.apply(FIFTH);
//
//        WinningMoney winningMoney = WinningMoney.of(statistics);
//
//        double expected =
//                (winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT)) * PROFIT_MULTIPLY;
//
//        // Act
//        double actual = Profit.of(winningMoney, purchaseCount).getPercentage();
//
//        // Assert
//        assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    void 수익률을_출력한다() {
//        int purchaseCount = 5;
//
//        Statistics statistics = Statistics.of();
//        statistics.apply(FIRST);
//        statistics.apply(SECOND);
//        statistics.apply(THIRD);
//        statistics.apply(FOURTH);
//        statistics.apply(FIFTH);
//
//        WinningMoney winningMoney = WinningMoney.of(statistics);
//
//        Profit profit = Profit.of(winningMoney, purchaseCount);
//
//        // Act
//        profit.print(LottoMessagePrinter.of(new OutputView()));
//
//        // Assert
//        String expected = String.format(LOTTO_PROFIT_MESSAGE.getMessage(), profit.getPercentage());
//        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expected);
//    }
}