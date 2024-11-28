package nl.naturalis.metl.core.token;

public final class NumberToken extends Token {

  public NumberToken(String code) {
    super(code);
  }

  @Override
  String extract(int offset) {
    String code = this.code;
    StringBuilder data = new StringBuilder();
    if (code.charAt(offset) == '+' || code.charAt(offset) == '-') {
      data.append(code.charAt(offset));
      offset++;
    }

    boolean hasDigits = false;
    boolean hasDecimalPoint = false;

    // Process the integer and fractional parts
    while (offset < code.length()) {
      char ch = code.charAt(offset);
      if (Character.isDigit(ch)) {
        data.append(ch);
        offset++;
        hasDigits = true;
      } else if (ch == '.' && !hasDecimalPoint) {
        data.append(ch);
        offset++;
        hasDecimalPoint = true;
      } else {
        break;
      }
    }


    if (offset < code.length() && (code.charAt(offset) == 'e' || code.charAt(offset) == 'E')) {
      data.append(code.charAt(offset));
      offset++;
      if (offset < code.length() && (code.charAt(offset) == '+' || code.charAt(offset) == '-')) {
        data.append(code.charAt(offset));
        offset++;
      }
      boolean hasExponentDigits = false;
      while (offset < code.length() && Character.isDigit(code.charAt(offset))) {
        data.append(code.charAt(offset));
        offset++;
        hasExponentDigits = true;
      }
      if (!hasExponentDigits) {
        throw new IllegalArgumentException("Invalid number format: exponent has no digits.");
      }
    }
    // Ensure at least one digit was found in the main part
    if (!hasDigits) {
      throw new IllegalArgumentException("Invalid number format: no digits found.");
    }
    return data.toString();
  }

}
