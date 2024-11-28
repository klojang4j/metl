package nl.naturalis.metl.core.token;

public abstract sealed class Token
    permits DQStringToken,
    FieldRefToken,
    NumberToken,
    OperatorToken,
    EORToken {

  final String code;

  String data;

  private int offset;

  public Token(String code) {
    this.code = code;
  }

  public final void get(int offset) {
    this.offset = offset;
    this.data = extract(offset);
  }

  final int offset() {
    return offset;
  }

  final int cursor() {
    return offset + data.length();
  }

  final String data() {
    return data;
  }

  abstract String extract(int offset);

  static boolean eof(String code, int cursor) {
    return cursor == code.length();
  }

}
