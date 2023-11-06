package lotto.view.output;

import java.util.List;
import java.util.Objects;

public class OutputMaker {
    public String lottoNumberCheckMaker(List<Integer> numbers) {
        StringBuilder lottoNumberList = new StringBuilder();
        Integer lastNumber = numbers.get(numbers.size() - 1);
        lottoNumberList.append("[");
        for (Integer number : numbers) {
            if (!Objects.equals(number, lastNumber)) {
                lottoNumberList.append(number).append(", ");
            }
            if (Objects.equals(number, lastNumber)) {
                lottoNumberList.append(number);
            }
        }
        lottoNumberList.append("]");
        return lottoNumberList.toString();
    }
}
