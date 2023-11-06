package lotto.io;

import lotto.domain.dto.Statistics;

import java.util.List;

public final class LottoOutput implements OutputPort{

    private final OutputConverter<List<List<Integer>>> lottosConverter;
    private final OutputConverter<Statistics> statisticsConverter;

    public LottoOutput(OutputConverter<List<List<Integer>>> lottosConverter, OutputConverter<Statistics> statisticsConverter) {
        this.lottosConverter = lottosConverter;
        this.statisticsConverter = statisticsConverter;
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printInputPurchaseAmount() {
        System.out.println(Message.INPUT_MONEY.value);
    }

    @Override
    public void printNumberOfLottos(Integer numberOfLottos) {
        System.out.printf(Message.PURCHASE_NUM.value, numberOfLottos);
    }

    @Override
    public void printCreatedLottos(List<List<Integer>> lottos) {
        System.out.println(lottosConverter.convert(lottos));
    }

    @Override
    public void printInputWinningNumbers() {
        System.out.println(Message.INPUT_WINNING_NUMBER.value);
    }

    @Override
    public void printInputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.value);
    }

    @Override
    public void printStatistics(Statistics statistics) {
        System.out.println(Message.STATISTICS_PREFIX.value);
        System.out.println(statisticsConverter.convert(statistics));
        System.out.printf(Message.REWARD_RATE.value, statistics.rate());
    }

    enum Message{
        NEW_LINE("\n"),
        INPUT_MONEY("구입금액을 입력해 주세요."),
        PURCHASE_NUM(NEW_LINE.value + "%d개를 구매했습니다." + NEW_LINE.value),
        INPUT_WINNING_NUMBER(NEW_LINE.value + "당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER(NEW_LINE.value + "보너스 번호를 입력해 주세요."),
        STATISTICS_PREFIX(NEW_LINE.value + "당첨 통계" + NEW_LINE.value + "---" + NEW_LINE.value),
        REWARD_RATE("총 수익률은 %,.1f%%입니다."),
        ;

        private final String value;

        Message(String value) {
            this.value = value;
        }
    }
}
