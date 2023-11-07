package lotto.view;

import static lotto.util.OutputEnum.PUBLISHED_LOTTO_COUNT_OUTPUT;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class OutputView{

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String SEPERATOR = ", ";

    public void printPublishedLottoCount(int lottoCount){
        System.out.println(lottoCount+PUBLISHED_LOTTO_COUNT_OUTPUT.message());
    }

    public void printPublishedLottos(Lottos lottos){
        for(Lotto lotto:lottos.getLottos()){
            printPublishedLotto(lotto);
        }
    }

    private void printPublishedLotto(Lotto lotto){
        StringBuilder output = new StringBuilder(OPEN_BRACKET);
        List<Integer> numbers = lotto.getNumbers();
        for (int i=0; i<numbers.size();i++){
            output.append(numbers.get(i));
            if(i!=numbers.size()-1){
                output.append(SEPERATOR);
            }
        }
        output.append(CLOSE_BRACKET);
        System.out.println(output.toString());
    }

    public void printWinningResult(){

    }

    public void printEarningRate(){

    }
}
