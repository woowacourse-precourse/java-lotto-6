package Controller;

public interface InputHandler<T> {
    public void validate(String input) throws IllegalArgumentException;

    public T getValidatedResult();
}
