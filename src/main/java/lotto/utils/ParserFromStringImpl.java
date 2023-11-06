package lotto.utils;

public class ParserFromStringImpl implements ParserFrom {

	@Override
	public int toIntPaser(String lottoString) {
		return Integer.parseInt(lottoString);
	}

	@Override
	public char toCharacterParser(String lottoString, int index) {
		return lottoString.charAt(index);
	}
}
