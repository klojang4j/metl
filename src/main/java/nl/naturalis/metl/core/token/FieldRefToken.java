package nl.naturalis.metl.core.token;

public final class FieldRefToken extends Token {

  public FieldRefToken(String code) {
    super(code);
  }

  @Override
  String extract(int offset) {
    String code = this.code;
    StringBuilder data = new StringBuilder();
    for (int i = offset; i < code.length(); i++) {
      char c = code.charAt(i);
      if (Character.isLetterOrDigit(c) || c == '_') {
        data.append(c);
      } else {
        break;
      }
    }
    return data.toString();
  }

}
