package lotto;

import lotto.util.Log;

public class Application {

    private static final LottoController lottoController = new LottoController();
    private static final Input input = new Input();
    public static void main(String[] args) {
        Log.println("구입금액을 입력해 주세요.");
        BaseResponse baseResponse = lottoController.buyLotto(input.buyMoney());
        Log.println(baseResponse.message());

        Log.println("당첨 번호를 입력해 주세요.");
        AnswerNumberRequestDto answerNumberRequestDto = input.answerNumber();

        Log.println("보너스 번호를 입력해주세요.");
        input.bonusNumber(answerNumberRequestDto);

        baseResponse = lottoController.getStatistics(answerNumberRequestDto);
        Log.println(baseResponse.message());
    }
}
