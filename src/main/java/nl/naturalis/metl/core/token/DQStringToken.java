package nl.naturalis.metl.core.token;

public final class DQStringToken extends Token {

  public DQStringToken(String code) {
    super(code);
  }

  @Override
  String extract(int offset) {
    String code = this.code;
    StringBuilder data = new StringBuilder();
    for (int i = offset + 1; i < code.length(); i++) {
      if (eof(code, i)) {
        throw new StringNotTerminatedException("");
      }
      char c = code.charAt(i);
      if (c == '"') {
        break;
      } else if (c == '\\') {
        ++i;
        if (eof(code, i)) {
          throw new StringNotTerminatedException("");
        }
        data.append(switch (code.charAt(i)) {
          case 'n' -> '\n';
          case 't' -> '\t';
          case 'b' -> '\b';
          case 'f' -> '\f';
          case 'r' -> '\r';
          case '\\' -> '\\';
          case '"' -> '\"';
          default -> throw new IllegalEscapeSequenceException("");
        });
      } else {
        data.append(c);
      }
    }
    return data.toString();
  }

}
