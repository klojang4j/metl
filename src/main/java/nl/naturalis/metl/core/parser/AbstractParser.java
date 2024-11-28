package nl.naturalis.metl.core.parser;

public abstract sealed class AbstractParser permits ArithmeticParser,
    ComparisonParser,
    ExpressionParser,
    FunctionParser,
    LogicalParser,
    StringOpParser,
    TerminalParser {
}
