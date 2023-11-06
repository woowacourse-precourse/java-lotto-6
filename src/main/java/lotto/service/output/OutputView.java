package lotto.service.output;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.calculate.GetReturnRateDto;
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
        printTitle();
        printHitStatus(getLottoResultDto);
    }

    private static void printTitle() {
        Printer.printStatistics();
        Printer.printLine();
    }

    private static void printHitStatus(GetLottoResultDto getLottoResultDto) {
        Printer.printThreeHit(getLottoResultDto.threeHit());
        Printer.printFourHit(getLottoResultDto.fourHit());
        Printer.printFiveHit(getLottoResultDto.fiveHit());
        Printer.printFiveWithBonusHit(getLottoResultDto.fiveHitWithBonus());
        Printer.printSixHit(getLottoResultDto.sixHit());
    }

    @Override
    public void printRate(GetReturnRateDto getReturnRateDto) {
        Printer.printRate(getReturnRateDto.lottoReturnRate());
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
        printNumbersIterationAfterSort(sortBeforeIteration(lotto));
    }

    private static void printNumbersIterationAfterSort(Integer[] sortedLotto) {
        for(int count = ZERO; count < sortedLotto.length; count++){
            Printer.printLottoNumber(sortedLotto[count]);
            checkLastNumber(sortedLotto, count);
        }
    }

    private static Integer[] sortBeforeIteration(Lotto lotto) {
        Integer[] array = lotto.lotto().toArray(new Integer[0]);
        Arrays.sort(array);
        return array;
    }

    private static void checkLastNumber(Integer[] sortedLotto, int count) {
        if(isNotLastNumber(sortedLotto, count)){
            Printer.printComma();
        }
    }

    private static boolean isNotLastNumber(Integer[] sortedLotto, int count) {
        return count != lastIndex(sortedLotto);
    }

    private static int lastIndex(Integer[] sortedLotto) {
        return
                sortedLotto.length- ONE;
    }
}
