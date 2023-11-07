package lotto.io;

import lotto.domain.dto.Statistics;

import java.util.List;

public final class FakeLottoOutput implements OutputPort{
    @Override
    public void printErrorMessage(String message) {}

    @Override
    public void printInputPurchaseAmount() {}

    @Override
    public void printNumberOfLottos(Integer numberOfLottos) {}

    @Override
    public void printCreatedLottos(List<List<Integer>> lottos) {}

    @Override
    public void printInputWinningNumbers() {}

    @Override
    public void printInputBonusNumber() {}

    @Override
    public void printStatistics(Statistics statistics) {}
}
