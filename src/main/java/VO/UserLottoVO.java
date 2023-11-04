package VO;

import domain.Lotto;

import java.util.List;

public class UserLottoVO {
    private List<Lotto> lottoList;
    private Integer pay;

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public List<Lotto> getLottoList() { return lottoList; }

    public Integer getPay() { return pay; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Lotto lotto : lottoList) {
            builder.append(lotto.toString()).append('\n'); // TODO: 상수 처리 필요
        }
        return builder.toString();
    }
}
