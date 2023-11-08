package lotto.service;

public interface Calculator<T> {
    T calculate(Long revenue, Long investmentCost);
}
