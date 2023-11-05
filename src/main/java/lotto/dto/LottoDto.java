package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class LottoDto {

    private final List<Integer> numbers;

    private LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<LottoDto> toDto(final List<Lotto> playerLotteries) {
        return playerLotteries.stream()
                .map(LottoDto::from)
                .toList();
    }

    private static LottoDto from(final Lotto playerLotto) {
        List<Integer> playerNumbers = playerLotto.getNumbers();
        return new LottoDto(playerNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
