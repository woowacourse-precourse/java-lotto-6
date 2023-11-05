package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoBundle(List<Lotto> bundle, int amount) {

}
