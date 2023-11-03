package lotto.dto.response;

import lotto.model.LottoNumber;

public class LottoNumberDto {
    private final int number;

    private LottoNumberDto(int number) {
        this.number = number;
    }

    public static LottoNumberDto from(LottoNumber number) {
        return new LottoNumberDto(number.getNumber());
    }

    public int getNumber() {
        return number;
    }
}
