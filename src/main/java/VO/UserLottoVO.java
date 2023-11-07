package VO;

import java.util.List;

import domain.Lotto;

public class UserLottoVO {

    private static final char NEW_LINE = '\n';
    private List<Lotto> lottoList;
    private Integer pay;

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Integer getPay() {
        return pay;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            builder.append(lotto.toString()).append(NEW_LINE);
        }
        return builder.toString();
    }
}
