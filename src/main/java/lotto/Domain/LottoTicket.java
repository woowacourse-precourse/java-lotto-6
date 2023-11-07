package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Util.NumbersGenerator;


public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(int lottoCount) throws IllegalArgumentException {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = NumbersGenerator.generateRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottoTicket() {return lottos;}

    public List<String> getLottoString() {
        return lottos.stream()
            .map(lotto -> lotto.toString())
            .collect(Collectors.toList());
    }
}
