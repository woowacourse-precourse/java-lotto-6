package lotto.view;


import java.util.List;
import lotto.controller.dto.LottoResponseDto;
import lotto.controller.dto.LottoResponseDtos;
import lotto.controller.dto.ResultResponseDto;

public class OutputView {

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printInputPrice() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
    }

    public static void printPurchaseLotto(int lottoCount) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printLottosValue(LottoResponseDtos lottoResponseDtos) {
        List<LottoResponseDto> dtos = lottoResponseDtos.toLottoResponseDto();
        for (LottoResponseDto dto : dtos) {
            printLottoValue(dto);
        }
    }

    public static void printLottoResult(List<ResultResponseDto> resultResponseDtos) {
        System.out.println("당첨 통계\n---");
        for (ResultResponseDto dto :
                resultResponseDtos) {
            printLottoResultEachRanking(dto);
        }
    }

    private static void printLottoResultEachRanking(ResultResponseDto resultResponseDto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resultResponseDto.getSameNumberCount()).append("개 일치 ");
        if (resultResponseDto.isHasBonus()) {
            stringBuilder.append("보너스 볼 일치 ");
        }
        stringBuilder.append("(").append(resultResponseDto.getWinnerPrice()).append(")")
                .append(" - ").append(resultResponseDto.getTotalCount()).append(" 개");

        System.out.println(stringBuilder.toString());
    }

    private static void printLottoValue(LottoResponseDto responseLottoDto) {
        List<Integer> lottoNumbers = responseLottoDto.getLottoNumber();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            stringBuilder.append(lottoNumbers.get(i));
            if (i < lottoNumbers.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    public static void printGetInputNumber() {
        System.out.println(INPUT_LOTTO_MESSAGE);
    }

    public static void printGetBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
