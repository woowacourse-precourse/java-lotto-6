package lotto.dto;

import java.lang.reflect.Array;

public class LottoGameDto {
    public static class Response{
        private final Long lottoGameId;

        public Response(Long lottoGameId) {
            this.lottoGameId = lottoGameId;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }
    }
    public static class Request{
        private final Long lottoGameId;

        public Request(Long lottoGameId) {
            this.lottoGameId = lottoGameId;
        }

        public Long getLottoGameId() {
            return lottoGameId;
        }
    }
    public static class Result{
        private final int three;
        private final int four;
        private final int five;
        private final int fiveAndBonus;
        private  final int six;

        public Result(int three, int four, int five, int fiveAndBonus, int six) {
            this.three = three;
            this.four = four;
            this.five = five;
            this.fiveAndBonus = fiveAndBonus;
            this.six = six;
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
    }

}
