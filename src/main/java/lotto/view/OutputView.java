package lotto.view;

import lotto.dto.LottoDto;

import java.util.List;

public interface OutputView {

    void printUserLotto(List<LottoDto> lottoDtos);

    default void print(Object printMessage) {
        System.out.println(printMessage);
    }
}
