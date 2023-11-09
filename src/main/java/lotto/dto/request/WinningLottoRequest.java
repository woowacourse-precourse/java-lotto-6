package lotto.dto.request;

public class WinningLottoRequest {

    private final String WinningLotto;

    public WinningLottoRequest(String winning) {
        this.WinningLotto = winning;
    }

    public String getWinningLotto() {
        return WinningLotto;
    }
}
