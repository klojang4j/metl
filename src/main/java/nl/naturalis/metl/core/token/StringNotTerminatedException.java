package nl.naturalis.metl.core.token;

public class StringNotTerminatedException extends RuntimeException {
  public StringNotTerminatedException(String message) {
    super(message);
  }
}
