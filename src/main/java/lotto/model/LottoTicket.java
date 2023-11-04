package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.service.LottoDto;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket() {
        lottos = new ArrayList<>();
    }

    public void addLotto(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    public List<LottoDto> toDto() {
        return lottos.stream()
                .map(LottoDto::of)
                .toList();
    }

}
