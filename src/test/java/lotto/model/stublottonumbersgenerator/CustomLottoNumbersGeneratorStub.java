package lotto.model.stublottonumbersgenerator;

import java.util.List;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

public class CustomLottoNumbersGeneratorStub implements LottoNumbersGenerator {
    private final List<Integer> numbers;

    public CustomLottoNumbersGeneratorStub(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
