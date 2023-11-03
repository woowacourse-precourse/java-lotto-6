package lotto.calculator;

public interface Calculator<Integer, U> {
	
	Integer calculateSum(U data);
    Double calculateTotalReturn(Integer money, Integer priceSum);
}