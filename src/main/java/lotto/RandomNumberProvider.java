package lotto;

import lotto.type.LottoType;

import java.util.List;

public interface RandomNumberProvider {
    List<Integer> generateRandomNumber();

    boolean supports(LottoType lottoType);
}
