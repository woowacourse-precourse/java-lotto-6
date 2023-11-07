package lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDTO {

    private String result;

    public void makeLottoDTO(List<Integer> numbers){

        List<Integer> sorted = numbers.stream().
                sorted().collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[").append(sorted.get(0)).append(", ")
                .append(sorted.get(1)).append(", ")
                .append(sorted.get(2)).append(", ")
                .append(sorted.get(3)).append(", ")
                .append(sorted.get(4)).append(", ")
                .append(sorted.get(5)).append("]");

        result = stringBuilder.toString();
    }

    @Override
    public String toString() {

        return result;
    }
}
