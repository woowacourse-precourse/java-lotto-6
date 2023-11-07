package lotto.model.vo;

import java.util.List;
public class SeasonLottoResultVO {
    private List<Integer> autoLottoNumber;
    private int autoBonusNumber;
    public List<Integer> getAutoLottoNumber() {
        return autoLottoNumber;
    }
    public int getAutoBonusNumber() {
        return autoBonusNumber;
    }
    public void setAutoLottoNumber(List<Integer> autoLottoNumber) {
        this.autoLottoNumber = autoLottoNumber;
    }
    public void setAutoBonusNumber(int autoBonusNumber) {
        this.autoBonusNumber = autoBonusNumber;
    }
}
