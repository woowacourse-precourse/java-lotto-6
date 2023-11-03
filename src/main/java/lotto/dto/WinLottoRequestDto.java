package lotto.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record WinLottoRequestDto(String lottoNumber) {

    public List<Integer> lottoStringToList() {
        List<Integer> lotto = new ArrayList<>();
        lotto = Arrays
                .stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .toList();

        return lotto;
    }
}
