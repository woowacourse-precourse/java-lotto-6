package lotto;

import java.util.List;

public class AnswerNumberRequestDto {
    private final Lotto lotto;

    public AnswerNumberRequestDto(List<Integer> lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
    }

    public static AnswerNumberRequestDto createDto(List<Integer> lottoNumbers) {
        return new AnswerNumberRequestDto(lottoNumbers);
    }
}
