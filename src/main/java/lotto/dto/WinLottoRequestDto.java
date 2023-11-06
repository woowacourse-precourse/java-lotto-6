package lotto.dto;

import static lotto.constants.LottoConfiguration.LOTTO_SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record WinLottoRequestDto(String lottoNumber) {

    public List<Integer> lottoStringToList() {
        List<Integer> lotto = new ArrayList<>();
        lotto = Arrays
                .stream(lottoNumber.split(LOTTO_SEPARATOR.getSeparator()))
                .map(Integer::parseInt)
                .toList();

        return lotto;
    }
}
