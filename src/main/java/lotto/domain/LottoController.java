package lotto.domain;

public class LottoController {
    private LottoController() {
        set();
        showResult();
    }

    public static LottoController start() {
        return new LottoController();
    }

    //티켓수, 당첨번호, 보너스번호 세팅
    public void set() {
        setBuyAmount();
        setWinningNumber();
        setBonusNumber();
    }

    private void setBuyAmount() {

    }

    private void setWinningNumber() {

    }

    private void setBonusNumber() {

    }

    //결과 생성
    public void showResult() {

    }
}
