package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoOutput {

    private StringBuffer stringBuffer;

    public String printRandomLotto(List<Integer> lottoNumbers){
        stringBuffer = new StringBuffer();

        stringBuffer.append("[");
        int lottoLength = lottoNumbers.size();
        for(int i = 0; i < lottoLength - 1; i++){
            stringBuffer.append(lottoNumbers.get(i)+", ");
        }
        stringBuffer.append(lottoNumbers.get(lottoLength - 1)+"]");
        String returnValue = stringBuffer.toString();
        System.out.println(returnValue);
        return returnValue;
    }

    public String printAllRandomLotto(List<Lotto> lottos){
        stringBuffer = new StringBuffer();

        for(Lotto lotto : lottos){
            stringBuffer.append(printRandomLotto(lotto.getNumbers()));
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
