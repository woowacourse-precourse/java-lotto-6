package lotto.view;

public class ExceptionView implements Exception{

	@Override
	public void PriceException(IllegalArgumentException e) {
		System.out.println(ExceptionText.ERROR.getText() + e.getMessage());
	}

}
