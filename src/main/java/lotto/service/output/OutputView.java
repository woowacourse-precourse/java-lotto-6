package lotto.service.output;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.result.GetLottoResultDto;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.generate.GetGeneratedLottosDto;
import lotto.util.message.Printer;

public class OutputView implements Output{
    private static final int ZERO = 0;
    private static final int ONE = 1;
    @Override
    public void printLottoNumbers(GetGeneratedLottosDto getGeneratedLottosDto) {
        printLottoNumbers(new GetLottosDto(getGeneratedLottosDto.getLottos()).getLottos());
    }

    @Override
    public void printLottoResult(GetLottoResultDto getLottoResultDto) {
        Printer.printThreeHit(getLottoResultDto.threeHit());
        Printer.printFourHit(getLottoResultDto.fourHit());
        Printer.printFiveHit(getLottoResultDto.fiveHit());
        Printer.printFiveWithBonusHit(getLottoResultDto.fiveHitWithBonus());
        Printer.printSixHit(getLottoResultDto.sixHit());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        Printer.printCount(lottos.size());
        printLottoNumbersIteration(lottos);
        Printer.changeLine();
    }

    private static void printLottoNumbersIteration(List<Lotto> lottos) {
        for (Lotto lotto : lottos){
            printOneLineNumbers(lotto);
        }
    }

    private static void printOneLineNumbers(Lotto lotto) {
        Printer.printOpen();
        printNumbersIteration(lotto);
        Printer.printClose();
    }

    private static void printNumbersIteration(Lotto lotto) {
        sortBeforeIteration(lotto);
        printNumbersIterationAfterSort(lotto);
    }

    private static void printNumbersIterationAfterSort(Lotto lotto) {
        for(int count = ZERO; count < lotto.lotto().size(); count++){
            Printer.printLottoNumber(lotto.lotto().get(count));
            checkLastNumber(lotto, count);
        }
    }

    private static void sortBeforeIteration(Lotto lotto) {
        Collections.sort(lotto.lotto());
    }

    private static void checkLastNumber(Lotto lotto, int count) {
        if(isNotLastNumber(lotto, count)){
            Printer.printComma();
        }
    }

    private static boolean isNotLastNumber(Lotto lotto, int count) {
        return count != lastIndex(lotto);
    }

    private static int lastIndex(Lotto lotto) {
        return lotto.lotto().size() - ONE;
    }
}
