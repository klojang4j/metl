package nl.naturalis.metl.core.token;

import java.util.Set;

public final class OperatorToken extends Token {

  private static final Set<Character> START_CHARS = Set.of(
      '+',
      '-',
      '*',
      '/',
      '&',
      '|',
      '=',
      '<',
      '>',
      '!',
      ':');

  private static final Set<String> ARITHMETIC_OPS = Set.of("+", "-", "*", "/");

  private static final Set<String> STRING_OPS = Set.of("&");

  private static final Set<String> LOGICAL_OPS = Set.of("&&", "||");

  private static final Set<String> COMPARISON_OPS = Set.of("==", "!=", "<", ">", "<=", ">=");

  private static final String LIBRARY_OP = "::";

  private static final Set<String> MULTI_CHAR_OPS = Set.of("&&", "||", "==", "!=", "<=", ">=", "::");

  public static boolean isOperatorStart(char ch) {
    return START_CHARS.contains(ch);
  }

  public OperatorToken(String code) {
    super(code);
  }

  @Override
  String extract(int offset) {
    String code = this.code;
    char c1 = code.charAt(offset);
    if (offset == code.length() - 1) {
      // This is going to cause problems because we have no unary operators,
      // but that's not our business
      return String.valueOf(c1);
    }
    char c2 = code.charAt(offset + 1);
    String op = String.valueOf(new char[]{c1, c2});
    if (MULTI_CHAR_OPS.contains(op)) {
      return op;
    }
    return String.valueOf(c1);
  }

  public boolean isArithmeticOperator() {
    return ARITHMETIC_OPS.contains(this.data);
  }

  public boolean isStringOperator() {
    return STRING_OPS.contains(this.data);
  }

  public boolean isLogicalOperator() {
    return LOGICAL_OPS.contains(this.data);
  }

  public boolean isComparisonOperator() {
    return COMPARISON_OPS.contains(this.data);
  }

  public boolean isLibraryOperator() {
    return LIBRARY_OP.equals(this.data);
  }

}
