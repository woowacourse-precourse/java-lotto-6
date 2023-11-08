package lotto.io;

public final class OutputViewPrinter implements Printer {

	@Override
	public void printLine(String message) {
		System.out.println(message);
	}
}