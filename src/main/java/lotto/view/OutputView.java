package lotto.view;


import static lotto.view.OutputMessage.BONUS_BALL_COUNT_MESSAGE;
import static lotto.view.OutputMessage.CORRECT_SAME_NUMBER_MESSAGE;
import static lotto.view.OutputMessage.EARNING_RATE_MESSAGE;
import static lotto.view.OutputMessage.PURCHASED_LOTTO_COUNT_MESSAGE;
import static lotto.view.OutputMessage.RATE_MESSAGE_FORMAT;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.LottoResponseDto;
import lotto.controller.dto.LottoResponseDtos;
import lotto.controller.dto.ResultResponseDto;

public class OutputView {

    public static void printInputPrice() {
        System.out.println(OutputMessage.INPUT_PURCHASE_MESSAGE);
    }

    public static void printPurchaseLotto(int lottoCount) {
        System.out.println(lottoCount + PURCHASED_LOTTO_COUNT_MESSAGE.getMessage());
    }

    public static void printLottosValue(LottoResponseDtos lottoResponseDtos) {
        List<LottoResponseDto> dtos = lottoResponseDtos.toLottoResponseDto();
        for (LottoResponseDto dto : dtos) {
            printLottoValue(dto);
        }
    }

    public static void printLottoResult(List<ResultResponseDto> resultResponseDtos) {
        System.out.println(OutputMessage.WINNING_STATICS_MESSAGE);
        for (ResultResponseDto dto : resultResponseDtos) {
            printLottoResultEachRanking(dto);
        }
    }

    private static void printLottoResultEachRanking(ResultResponseDto resultResponseDto) {
        String message = String.format(CORRECT_SAME_NUMBER_MESSAGE.getMessage(),
                resultResponseDto.getSameNumberCount());

        if (resultResponseDto.isHasBonus()) {
            message += BONUS_BALL_COUNT_MESSAGE.getMessage();
        }

        message += String.format(RATE_MESSAGE_FORMAT.getMessage(),
                resultResponseDto.getWinnerPriceFormatted(), resultResponseDto.getTotalCount());

        System.out.println(message);
    }

    private static void printLottoValue(LottoResponseDto responseLottoDto) {
        List<Integer> lottoNumbers = responseLottoDto.getLottoNumber();
        String joinedNumbers = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedNumbers);
    }

    public static void printGetInputNumber() {
        System.out.println(OutputMessage.INPUT_LOTTO_MESSAGE);
    }

    public static void printGetBonusNumber() {
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf(EARNING_RATE_MESSAGE.getMessage(), earningRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
