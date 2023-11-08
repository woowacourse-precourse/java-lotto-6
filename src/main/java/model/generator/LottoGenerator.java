package model.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Lotto;

public class LottoGenerator {

    public static List<Lotto> generateLottoGroup(int createLottoCount) {
        return IntStream.range(0, createLottoCount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    public static Lotto generateLotto() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        return new Lotto(lottoNumbersGenerator.generateLottoNumbers());
    }
}
