package Controller;

public interface InputHandler<T> {
    public void validate(String input);

    public T getValidatedResult();
}
