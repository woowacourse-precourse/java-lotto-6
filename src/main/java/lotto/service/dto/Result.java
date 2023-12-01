package lotto.service.dto;

public record Result(
    int countOfFirst,
    int countOfSecond,
    int countOfThird,
    int countOfForth,
    int countOfFifth,
    float earningRate
) {

}
