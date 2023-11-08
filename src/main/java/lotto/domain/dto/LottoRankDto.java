package lotto.domain.dto;

public record LottoRankDto(
        int standardOfFifthPlace,  int prizeOfFifthPlace,
        int standardOfFourthPlace,  int prizeOfFourthPlace,
        int standardOfThirdPlace,  int prizeOfThirdPlace,
        int standardOfSecondPlace,  int prizeOfSecondPlace,
        int standardOfFirstPlace,  int prizeOfFirstPlace
){

}