package scalariform.lexer

import scalariform.lexer.Tokens._
import scalariform.utils.Range

/**
 * A token of Scala source.
 *
 * @param text -- the text associated with the token after unicode escaping
 * @param rawText -- the text associated with the token before unicode escaping
 */
case class Token(tokenType: TokenType, text: String, offset: Int, rawText: String) {

  private[lexer] var associatedWhitespaceAndComments_ : HiddenTokens = null

  private[lexer] var containsUnicodeEscape = false

  def associatedWhitespaceAndComments: HiddenTokens = associatedWhitespaceAndComments_

  def length = rawText.length

  def range = Range(offset, length)

  def lastCharacterOffset = offset + length - 1

  def isScalaDocComment = tokenType == MULTILINE_COMMENT && text.startsWith("/**") && text != "/**/"

  def isNewline = tokenType.isNewline

  def isNewlines = tokenType.isNewlines

  @deprecated(message = "Use text instead" /*, since = "0.1.2"*/ )
  def getText = text

  @deprecated(message = "Use offset instead" /*, since = "0.1.2"*/ )
  def startIndex = offset

  @deprecated(message = "Use lastCharacterOffset instead" /*, since = "0.1.2"*/ )
  def stopIndex = lastCharacterOffset

}