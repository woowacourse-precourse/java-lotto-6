package lotto.view;

import java.util.List;
import lotto.dto.response.LottoDto;
import lotto.dto.response.LottoGroupDto;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String LOTTO_GROUP_SIZE_FORMAT = "%d개를 구매했습니다.";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printExceptionMessage(String exceptionMessage) {
        String formattedExceptionMessage = String.format(EXCEPTION_FORMAT, exceptionMessage);
        println(formattedExceptionMessage);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printLottoGroup(LottoGroupDto lottoGroupDto) {
        int lottoGroupSize = lottoGroupDto.getSize();
        printSize(lottoGroupSize);
        printLottos(lottoGroupDto.getLottos());
    }

    private void printSize(int lottoGroupSize) {
        String message = String.format(LOTTO_GROUP_SIZE_FORMAT, lottoGroupSize);
        println(message);
    }

    private void printLottos(List<LottoDto> lottos) {
        lottos.forEach(this::printLotto);
    }

    private void printLotto(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getNumbers();
        String formattedLottoNumbers = numbers.toString();
        println(formattedLottoNumbers);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
