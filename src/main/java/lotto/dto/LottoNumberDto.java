package lotto.dto;

import lotto.domain.LottoNumber;

public record LottoNumberDto(int number) {

    public static LottoNumberDto from(LottoNumber lottoNumber) {
        return new LottoNumberDto(lottoNumber.getNumber());
    }

    public int getNumber() {
        return this.number;
    }
}
