package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputMaker {
    static StringBuilder stringBuilder;
    public OutputMaker() {
        stringBuilder = new StringBuilder();
    }
    public String printLotto(Lotto lotto) {
        initStringBuilder();
        List<Integer> thisLotto = new ArrayList<>(lotto.getNumbers());
        stringBuilder.append("[");
        Collections.sort(thisLotto);
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(thisLotto.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(thisLotto.get(5));
        stringBuilder.append("]");
        return String.valueOf(stringBuilder);
    }

    public String printResult(double revenue) {
        initStringBuilder();
        stringBuilder.append("당첨 통계"+"\n");
        stringBuilder.append("---"+"\n");
        stringBuilder.append("3개 일치 ("
                +String.format("%,d", LottoRank.RANK5.getPrize())+"원) - "
                +LottoRank.RANK5.getCount()+"개"
                +"\n");
        stringBuilder.append("4개 일치 ("
                +String.format("%,d", LottoRank.RANK4.getPrize())+"원) - "
                +LottoRank.RANK4.getCount()+"개"
                +"\n");
        stringBuilder.append("5개 일치 ("
                +String.format("%,d", LottoRank.RANK3.getPrize())+"원) - "
                +LottoRank.RANK3.getCount()+"개"
                +"\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 ("
                +String.format("%,d", LottoRank.RANK2.getPrize())+"원) - "
                +LottoRank.RANK2.getCount()+"개"
                +"\n");
        stringBuilder.append("6개 일치 ("
                +String.format("%,d", LottoRank.RANK1.getPrize())+"원) - "
                +LottoRank.RANK1.getCount()+"개"
                +"\n");
        stringBuilder.append("총 수익률은 "+String.format("%.1f",revenue)+"%입니다.");
        return String.valueOf(stringBuilder);
    }

    private void initStringBuilder() {
        if(!stringBuilder.isEmpty()){stringBuilder.setLength(0);}
    }
}
