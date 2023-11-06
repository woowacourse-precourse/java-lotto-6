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

    }

    @Override
    public void printInputPurchaseAmount() {

    }

    @Override
    public void printNumberOfLottos(Integer numberOfLottos) {

    }

    @Override
    public void printCreatedLottos(List<List<Integer>> lottos) {

    }

    @Override
    public void printInputWinningNumbers() {

    }

    @Override
    public void printInputBonusNumber() {

    }

    @Override
    public void printStatistics(Statistics statistics) {

    }
}
