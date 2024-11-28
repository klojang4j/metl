package nl.naturalis.metl.core.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {

  @Test
  public void skipWhitespace00() {
    String code = """
        hello
        """;
    assertEquals(0, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace01() {
    String code = "";
    assertEquals(0, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace02() {
    String code = " ";
    assertEquals(1, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace03() {
    String code = "  ";
    assertEquals(2, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace04() {
    String code = "  \n";
    assertEquals(3, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace05() {
    String code = "#";
    assertEquals(1, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace06() {
    String code = "#hello";
    assertEquals(6, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace07() {
    String code = "#hello\n   hello";
    assertEquals(10, Tokenizer.skipWhitespace(code, 0));
  }

  @Test
  public void skipWhitespace08() {
    String code = "hello";
    assertEquals(2, Tokenizer.skipWhitespace(code, 2));
  }


}
