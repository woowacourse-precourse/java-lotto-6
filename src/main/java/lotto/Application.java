package lotto;

import lotto.controller.LottoController;
import lotto.dto.request.AnswerNumberRequestDto;
import lotto.dto.response.LottosResponseDto;
import lotto.util.BaseResponse;
import lotto.util.Input;
import lotto.util.Log;

public class Application {

    private static final LottoController lottoController = new LottoController();
    private static final Input input = new Input();

    public static void main(String[] args) {
        Log.println("구입금액을 입력해 주세요.");
        BaseResponse<LottosResponseDto> lottoInformationResponse = lottoController.buyLotto(input.buyMoney());
        Log.println(lottoInformationResponse.message());
        lottoInformationResponse.data()
                .lottos()
                .forEach(lotto -> System.out.println(lotto.toString()));
        Log.println("당첨 번호를 입력해 주세요.");
        AnswerNumberRequestDto answerNumberRequestDto = input.answerNumber();

        Log.println("보너스 번호를 입력해주세요.");
        input.bonusNumber(answerNumberRequestDto);

        BaseResponse<?> statisticsResponse = lottoController.getStatistics(answerNumberRequestDto);
        Log.println(statisticsResponse.message());
    }
}
