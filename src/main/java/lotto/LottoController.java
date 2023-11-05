package lotto;

public class LottoController {
    public BaseResponse buyLotto(int money) {
        return BaseResponse.okWithData(money / 1000 + "개를 구매했습니다.", new LottosResponseDto());
    }

    public BaseResponse getStatistics(AnswerNumberRequestDto answerNumberRequestDto) {
        return BaseResponse.okWithData("당첨 통계", new StatisticsResponseDto());
    }
}
