package lotto.util.dto.request;

public class LottoNumberDto {

    private final String lottoNumbers;

    public LottoNumberDto(String lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String getLottoNumbers() {
        return lottoNumbers;
    }
}
