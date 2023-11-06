package lotto.service.output;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.generate.GetGeneratedLottosDto;

public class OutputView implements Output{
    private static final int ZERO = 0;
    private static final int ONE = 1;
    @Override
    public void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto) {
        printLottoNumbers(new GetLottosDto(getGeneratedLottosDto.getLottos()).getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        printLottoNumbersIteration(lottos);
    }

    private static void printLottoNumbersIteration(List<Lotto> lottos) {
        for (Lotto lotto : lottos){
            printOneLineNumbers(lotto);
        }
    }

    private static void printOneLineNumbers(Lotto lotto) {
        System.out.print("[");
        printNumbersIteration(lotto);
        System.out.print("]\n");
    }

    private static void printNumbersIteration(Lotto lotto) {
        sortBeforeIteration(lotto);
        printNumbersIterationAfterSort(lotto);
    }

    private static void printNumbersIterationAfterSort(Lotto lotto) {
        for(int count = ZERO; count < lotto.lotto().size(); count++){
            System.out.printf("%d", lotto.lotto().get(count));
            checkLastNumber(lotto, count);
        }
    }

    private static void sortBeforeIteration(Lotto lotto) {
        Collections.sort(lotto.lotto());
    }

    private static void checkLastNumber(Lotto lotto, int count) {
        if(isNotLastNumber(lotto, count)){
            System.out.print(", ");
        }
    }

    private static boolean isNotLastNumber(Lotto lotto, int count) {
        return count != lastIndex(lotto);
    }

    private static int lastIndex(Lotto lotto) {
        return lotto.lotto().size() - ONE;
    }
}
