package lotto;

public enum Rank {
	FIRST(2000000000),
	SECOND(30000000),
	THIRD(1500000),
	FOURTH(50000),
	FIFTH(5000);

	private final int prize; // 정수를 저장할 필드(인스턴스 변수) 추가

	Rank(int prize) {
		this.prize = prize;
	}

	public int getPrize() {
		return prize;
	}
}
