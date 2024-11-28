package nl.naturalis.metl.core.token;

import java.util.List;

public final class Tokenizer {

  private final String code;

  private int cursor;

  public Tokenizer(String code) {
    this.code = code;
  }

  public List<Token> getTokens() {
    return null;
  }

  public Token nextToken(List<Token> acceptableTokens) {
    return null;
  }

  public int cursor() {
    return cursor;
  }

  private void skipWhitespace() {
    cursor = skipWhitespace(code, cursor);
  }

  // VisibleForTesting
  static int skipWhitespace(String code, int cursor) {
    while (cursor < code.length()) {
      if (Character.isWhitespace(code.charAt(cursor))) {
        ++cursor;
      } else if (code.charAt(cursor) == '#' && (cursor == 0 || isEOL(code, cursor - 1))) {
        while (cursor < code.length() && !isEOL(code, cursor)) {
          ++cursor;
        }
        skipWhitespace(code, cursor);
      } else {
        break;
      }
    }
    return cursor;
  }


  // end-of-line
  private static boolean isEOL(String code, int cursor) {
    return code.charAt(cursor) == '\n' || code.charAt(cursor) == '\r';
  }
}
