package lotto.dto;

import java.lang.reflect.Array;
import java.util.List;

public class LottoGameDto {

    public static class CreateResponse{
        private final Long lottoGameId;
        private final Integer amount;

        public CreateResponse(Long lottoGameId, Integer amount) {
            this.lottoGameId = lottoGameId;
            this.amount = amount;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }

        public Integer getAmount() {
            return amount;
        }
    }
    public static class InitRequest{
        private Long lottoGameId;

        public InitRequest(Long lottoGameId) {
            this.lottoGameId = lottoGameId;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }
    }
    public static class Response{
        private final Long lottoGameId;
        private final List<List<Integer>> lottoNubers;

        public Response(Long lottoGameId, List<List<Integer>> lottoNubers) {
            this.lottoGameId = lottoGameId;
            this.lottoNubers = lottoNubers;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }

        public List<List<Integer>> getLottoNubers() {
            return lottoNubers;
        }
    }
    public static class Request{
        private final Long lottoGameId;

        private final List<Integer> winningNumbers;
        private final Integer bonusNumber;


        public Request(Long lottoGameId, List<Integer> winningNumbers, Integer bonusNumber) {
            this.lottoGameId = lottoGameId;
            this.winningNumbers = winningNumbers;
            this.bonusNumber = bonusNumber;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }

        public List<Integer> getWinningNumbers() {
            return winningNumbers;
        }

        public Integer getBonusNumber() {
            return bonusNumber;
        }
    }
    public static class Result{
        private final int three;
        private final int four;
        private final int five;
        private final int fiveAndBonus;
        private  final int six;
        private final float rate;

        public Result(int three, int four, int five, int fiveAndBonus, int six, float rate) {
            this.three = three;
            this.four = four;
            this.five = five;
            this.fiveAndBonus = fiveAndBonus;
            this.six = six;
            this.rate = rate;
        }

        public int getThree() {
            return three;
        }

        public int getFour() {
            return four;
        }

        public int getFive() {
            return five;
        }

        public int getFiveAndBonus() {
            return fiveAndBonus;
        }

        public int getSix() {
            return six;
        }

        public float getRate() {
            return rate;
        }
    }

}
