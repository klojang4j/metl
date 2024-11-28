package nl.naturalis.metl.core.token;

public final class EORToken extends Token {

  public EORToken() {
    super(null);
  }


  @Override
  String extract(int offset) {
    throw new UnsupportedOperationException("End Of Rule");
  }

}
