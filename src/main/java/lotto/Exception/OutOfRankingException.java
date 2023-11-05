package lotto.Exception;

public class OutOfRankingException extends IllegalArgumentException
{
    public OutOfRankingException(String message)
    {
        super(message);
    }
}
