package nl.naturalis.metl.core.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTokenTest {

  @Test
  public void extract00() {
    NumberToken token = new NumberToken("4");
    token.get(0);
    assertEquals("4", token.data());
  }
}
