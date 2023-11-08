package lotto.domain.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class LottoBundleDto {
    private final List<Lotto> lottoBundleData;
    private final int numberOfLottoBundle;

    public LottoBundleDto(List<Lotto> lottoBundleData, int numberOfLottoBundle) {
        this.lottoBundleData = lottoBundleData;
        this.numberOfLottoBundle = numberOfLottoBundle;
    }

    public List<Lotto> getLottoBundleData() {
        return Collections.unmodifiableList(lottoBundleData);
    }

    public int getNumberOfLottoBundle() {
        return numberOfLottoBundle;
    }
}
