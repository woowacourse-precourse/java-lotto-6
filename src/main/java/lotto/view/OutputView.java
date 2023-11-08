package lotto.view;

import lotto.dto.*;

import java.util.List;

import static lotto.constants.ViewConstants.*;
import static lotto.view.ViewMessage.*;

public class OutputView {

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printInputLottoPurchaseAmount() {
        println(INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
    }

    public void printInputWinningLotto() {
        printNewLine();
        println(INPUT_WINNING_LOTTO.getMessage());
    }

    public void printInputBonusNumber() {
        printNewLine();
        println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void printLottoPurchaseCount(final LottoCountDTO lottoCountDTO) {
        printNewLine();
        println(String.format(OUTPUT_LOTTO_PURCHASE_COUNT.getMessage(), lottoCountDTO.lottoCount()));
    }

    public void printLottoNumbers(final LottoNumbersDTO lottoNumbersDTO) {
        String lottoNumbersMessage = String.join(OUTPUT_LOTTO_NUMBERS_DELIMITER.getMessage(),
                lottoNumbersDTO.numbers());
        println(String.format(OUTPUT_LOTTO_NUMBERS.getMessage(), lottoNumbersMessage));
    }

    public void printLottoWinningStatistics(final LottoResultDTO lottoResultDTO) {
        printNewLine();
        println(OUTPUT_LOTTO_WINNING_STATISTICS.getMessage());
        printThreeNumberMatch(lottoResultDTO.lottoWinningResultDTOs());
        printFourNumberMatch(lottoResultDTO.lottoWinningResultDTOs());
        printFiveNumberMatch(lottoResultDTO.lottoWinningResultDTOs());
        printFiveNumberAndBonusNumberMatch(lottoResultDTO.lottoWinningResultDTOs());
        printSixNumberMatch(lottoResultDTO.lottoWinningResultDTOs());
        printLottoReturns(lottoResultDTO.lottoReturnsRateDTO());
    }

    private void printThreeNumberMatch(final List<LottoWinningResultDTO> lottoWinningResultDTOs) {
        int count = (int) lottoWinningResultDTOs.stream()
                .map(LottoWinningResultDTO::numberMatchCount)
                .filter(numberMatchCount -> numberMatchCount == LOTTO_THREE_NUMBER_MATCH.getValue())
                .count();
        println(String.format(OUTPUT_LOTTO_THREE_NUMBER_MATCH.getMessage(), count));
    }

    private void printFourNumberMatch(final List<LottoWinningResultDTO> lottoWinningResultDTOs) {
        int count = (int) lottoWinningResultDTOs.stream()
                .map(LottoWinningResultDTO::numberMatchCount)
                .filter(numberMatchCount -> numberMatchCount == LOTTO_FOUR_NUMBER_MATCH.getValue())
                .count();
        println(String.format(OUTPUT_LOTTO_FOUR_NUMBER_MATCH.getMessage(), count));
    }

    private void printFiveNumberMatch(final List<LottoWinningResultDTO> lottoWinningResultDTOs) {
        int count = (int) lottoWinningResultDTOs.stream()
                .filter(lottoWinningResultDTO ->
                        lottoWinningResultDTO.numberMatchCount() == LOTTO_FIVE_NUMBER_MATCH.getValue()
                                && !lottoWinningResultDTO.isBonusNumberMatch())
                .count();
        println(String.format(OUTPUT_LOTTO_FIVE_NUMBER_MATCH.getMessage(), count));
    }

    private void printFiveNumberAndBonusNumberMatch(final List<LottoWinningResultDTO> lottoWinningResultDTOs) {
        int count = (int) lottoWinningResultDTOs.stream()
                .filter(lottoWinningResultDTO ->
                        lottoWinningResultDTO.numberMatchCount() == LOTTO_FIVE_NUMBER_MATCH.getValue()
                                && lottoWinningResultDTO.isBonusNumberMatch())
                .count();
        println(String.format(OUTPUT_LOTTO_FIVE_NUMBER_BONUS_NUMBER_MATCH.getMessage(), count));
    }

    private void printSixNumberMatch(final List<LottoWinningResultDTO> lottoWinningResultDTOs) {
        int count = (int) lottoWinningResultDTOs.stream()
                .map(LottoWinningResultDTO::numberMatchCount)
                .filter(numberMatchCount -> numberMatchCount == LOTTO_SIX_NUMBER_MATCH.getValue())
                .count();
        println(String.format(OUTPUT_LOTTO_SIX_NUMBER_MATCH.getMessage(), count));
    }

    private void printLottoReturns(final LottoReturnsRateDTO lottoReturnsRateDTO) {
        print(String.format(OUTPUT_LOTTO_RETURNS.getMessage(), lottoReturnsRateDTO.lottoReturnsRate()));
    }

    public void printErrorMessage(final String message) {
        println(message);
    }

    private static void print(final String Message) {
        System.out.print(Message);
    }

    private static void println(final String Message) {
        System.out.println(Message);
    }

    private static void printNewLine() {
        System.out.println();
    }
}