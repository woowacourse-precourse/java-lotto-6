package lotto;

import java.util.Map;
import java.util.Map.Entry;

public enum LottoResult {
	THREE_ACCORD("3개 일치 (5,000원) - %d개", 5000),
	FOUR_ACCORD("4개 일치 (50,000원) - %d개", 50000),
	FIVE_ACCORD("5개 일치 (1,500,000원) - %d개", 1500000),
	FIVE_AND_BONERCE_ACCORD("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
	SIX_ACCORD("6개 일치 (2,000,000,000원) - %d개", 2000000000);


	private final String value;
	private final int price;

	LottoResult(String value, int price) {
		this.value = value;
		this.price = price;
	}

	public String getValue() {
		return value;
	}

	public int getPrice() {
		return price;
	}

	String getResult(Map<LottoResult, Integer> results) {
		Integer count = results.get(this);
		if (count == null) count = 0;
		return String.format(this.getValue(), count);
	}

	String getPriceResult(Map<LottoResult, Integer> results) {
		int count = results.get(this);
		return String.format(this.getValue(), count);
	}

	static int getTotalPriceResult(Map<LottoResult, Integer> results) {
		int total = 0;
		for (Entry<LottoResult, Integer> entry : results.entrySet()) {
			total += entry.getKey().price * entry.getValue();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return total;
	}
}
