package lotto.view;

import lotto.dto.*;

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
        printFifthRankCount(lottoResultDTO.lottoWinningResultDTO());
        printFourthRankCount(lottoResultDTO.lottoWinningResultDTO());
        printThirdRankCount(lottoResultDTO.lottoWinningResultDTO());
        printSecondRankCount(lottoResultDTO.lottoWinningResultDTO());
        printFirstRankCount(lottoResultDTO.lottoWinningResultDTO());
        printLottoReturns(lottoResultDTO.lottoReturnsRateDTO());
    }

    private void printFifthRankCount(final LottoWinningResultDTO lottoWinningResultDTO) {
        println(String.format(OUTPUT_LOTTO_FIFTH_RANK_COUNT.getMessage(), lottoWinningResultDTO.fifthRankCount()));
    }

    private void printFourthRankCount(final LottoWinningResultDTO lottoWinningResultDTO) {
        println(String.format(OUTPUT_LOTTO_FOURTH_RANK_COUNT.getMessage(), lottoWinningResultDTO.fourthRankCount()));
    }

    private void printThirdRankCount(final LottoWinningResultDTO lottoWinningResultDTO) {
        println(String.format(OUTPUT_LOTTO_THIRD_RANK_COUNT.getMessage(), lottoWinningResultDTO.thirdRankCount()));
    }

    private void printSecondRankCount(final LottoWinningResultDTO lottoWinningResultDTO) {
        println(String.format(OUTPUT_LOTTO_SECOND_RANK_COUNT.getMessage(),
                lottoWinningResultDTO.secondRankCount()));
    }

    private void printFirstRankCount(final LottoWinningResultDTO lottoWinningResultDTO) {
        println(String.format(OUTPUT_LOTTO_FIRST_RANK_COUNT.getMessage(), lottoWinningResultDTO.firstRankCount()));
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
