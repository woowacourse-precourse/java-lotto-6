package lotto.dto;

public class ResponseDto {

    public static class LottoGameResultDto{
        private int[] countWinning;
        private double rateOfReturn;

        public LottoGameResultDto(){}

        public LottoGameResultDto(int[] countWinning, double rateOfReturn){
            this.countWinning = countWinning;
            this.rateOfReturn = rateOfReturn;
        }

        public int[] getCountWinning() {
            return countWinning;
        }

        public double getRateOfReturn() {
            return rateOfReturn;
        }
    }



}
