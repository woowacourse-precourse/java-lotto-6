package lotto.dto.request;

public class LottoNumberRequest {
    private int lottoNumber;

    public LottoNumberRequest(String lottoNumber) {
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
