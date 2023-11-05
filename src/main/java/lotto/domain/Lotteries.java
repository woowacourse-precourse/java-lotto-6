package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ExceptionConstant;
import lotto.constant.NumberConstant;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(List<Integer> lottoNumbers) {
        this.lotteries = generateLotteries(lottoNumbers);
    }

    public static Lotteries from(List<Integer> lottoNumbers) {
        return new Lotteries(lottoNumbers);
    }

    public List<Lotto> generateLotteries(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> new Lotto(lottoNumbers))
                .collect(Collectors.toList());
    }
}
