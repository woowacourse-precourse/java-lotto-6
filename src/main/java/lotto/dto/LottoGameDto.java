package lotto.dto;

import java.lang.reflect.Array;
import java.util.List;

public class LottoGameDto {
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
