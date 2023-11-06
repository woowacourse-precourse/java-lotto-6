package lotto.View;

import static lotto.View.OutputMessage.Enter_Purchase_Mount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.VO.LottoData;

public class Output {
    public static void printEnterPurchaseMount(){
        System.out.println(Enter_Purchase_Mount.message);
    }
    public static void printLottos(ArrayList<LottoData> lottos){
        System.out.println();
        System.out.printf("%d개를 구매했습니다.",lottos.size());
        System.out.println();
        lottos.stream()
                .map(LottoData::getNumbers)
                .forEach(Output::printLotto);
    }
    private static void printLotto(List<Integer> lotto) {
        List<Integer> sortedNumbers = lotto.stream()
                .sorted()
                .toList();

        String formattedLotto = sortedNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(formattedLotto);
    }

}
