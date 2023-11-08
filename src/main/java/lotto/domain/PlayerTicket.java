package lotto.domain;
//입력값(=티켓값) 타입은 정수이다
//입력값은 자연수이다.
//입력값은 1000단위의 수이다.
public class PlayerTicket {
	private static final int MIN_TICKET_AMOUNT = 1000;
	private int amount;
	
	//가능한 구매총액 입력
	public PlayerTicket(String amount) {
		int ticketAmount = possibleNumber(amount);
		possibleNaturalOr0(ticketAmount);
		possibleDivision(ticketAmount);
		this.amount = ticketAmount;
	}
	
	public int TicketCount() {
		return amount / MIN_TICKET_AMOUNT;
	}
	
	//입력한 값이 숫자인지
	public static int possibleNumber(String amount) {
		try {
			return Integer.parseInt(amount);
		} catch(NumberFormatException e) {
			ErrorMessage.numberError();
			throw new IllegalArgumentException();
		}
	}
	
	//입력한 값이 0이상의 정수인지
	public void possibleNaturalOr0(int amount) {
		if(amount <= 0) {
			ErrorMessage.naturalOr0Error();
			throw new IllegalArgumentException();
		}
	}
	
	//입력한 값이 1000단위의 수인지
	public void possibleDivision(int amount) {
		if(amount % MIN_TICKET_AMOUNT != 0) {
			ErrorMessage.divisionError();
			throw new IllegalArgumentException();
		}
	}
}
