package lotto.view;

import java.util.List;

public class LottoOutput {

    public String printRandomLotto(List<Integer> lottoNumbers){
        StringBuffer stringBuffer = new StringBuffer();

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
}
