package lotto.dto;

public class ResponseDto {

    public static class LottoGameResultDto{
        private int rankingOneCnt;
        private int rankingTwoCnt;
        private int rankingThreeCnt;
        private int rankingFourCnt;
        private int rankingFiveCnt;
        private double rateOfReturn;

        public LottoGameResultDto(){};

        public LottoGameResultDto(int[] countWinning, double rateOfReturn){
            this.rankingOneCnt = countWinning[1];
            this.rankingTwoCnt = countWinning[2];
            this.rankingThreeCnt = countWinning[3];
            this.rankingFourCnt = countWinning[4];
            this.rankingFiveCnt = countWinning[5];
            this.rateOfReturn = rateOfReturn;
        }

        public int getRankingOneCnt() {
            return rankingOneCnt;
        }

        public int getRankingTwoCnt() {
            return rankingTwoCnt;
        }

        public int getRankingThreeCnt() {
            return rankingThreeCnt;
        }

        public int getRankingFourCnt() {
            return rankingFourCnt;
        }

        public int getRankingFiveCnt() {
            return rankingFiveCnt;
        }
    }



}
