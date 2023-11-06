package lotto.Service;

import lotto.domain.LottoEnum;

import java.util.Arrays;
import java.util.List;

public class InputService {

    public Integer getStringPriceToInt(String line) {
        return Integer.parseInt(line) / LottoEnum.LOTTO_PRICE.getStatus();
    }

    public void isString(String line) {
        List<String> lineList = Arrays.stream(line.split(",")).toList();
        for (String str : lineList) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getStringToList(String line) {
        return Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
    }

    public boolean is1To45(List<Integer> winningNum) {
        return winningNum.stream().anyMatch(num -> num < 1 || num > 45);
    }
}
