package lotto.calculator;

public interface Calculator<T extends Number, U> {

	T calculateSum(U data);
	Double calculateRate(T amount, T total);
}