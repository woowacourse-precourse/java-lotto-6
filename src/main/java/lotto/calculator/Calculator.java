package lotto.calculator;

public interface Calculator<T extends Number, U> {
	
	T calculateSum(U data);
    Double calculateTotalReturn(T money, T priceSum);
}