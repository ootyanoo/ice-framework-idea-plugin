/* The following code was generated by JFlex 1.4.3 on 04.01.12 16:13 */

/* It's an automatically generated code. Do not modify it. */
package org.xblackcat.frozenice;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

@SuppressWarnings({"ALL"})

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 04.01.12 16:13 from the specification file
 * <tt>P:/learn.projects/FrozenIdea/src/java/org/xblackcat/frozenice/_IceLexer.flex</tt>
 */
class _IceLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\4\1\1\1\7\1\0\1\1\1\7\16\4\4\0\1\1\2\0"+
    "\1\10\1\3\3\0\1\45\1\46\1\6\1\0\1\54\1\0\1\55"+
    "\1\5\12\4\1\0\1\53\1\43\1\0\1\44\2\0\13\3\1\34"+
    "\2\3\1\35\13\3\1\51\1\2\1\52\1\0\1\3\1\0\1\16"+
    "\1\21\1\24\1\32\1\14\1\15\1\37\1\33\1\26\1\36\1\3"+
    "\1\17\1\40\1\27\1\22\1\25\1\30\1\12\1\20\1\11\1\13"+
    "\1\42\1\41\1\23\1\31\1\3\1\47\1\0\1\50\1\0\41\4"+
    "\2\0\4\3\4\0\1\3\2\0\1\4\7\0\1\3\4\0\1\3"+
    "\5\0\27\3\1\0\37\3\1\0\u013f\3\31\0\162\3\4\0\14\3"+
    "\16\0\5\3\11\0\1\3\21\0\130\4\5\0\23\4\12\0\1\3"+
    "\13\0\1\3\1\0\3\3\1\0\1\3\1\0\24\3\1\0\54\3"+
    "\1\0\46\3\1\0\5\3\4\0\202\3\1\0\4\4\3\0\105\3"+
    "\1\0\46\3\2\0\2\3\6\0\20\3\41\0\46\3\2\0\1\3"+
    "\7\0\47\3\11\0\21\4\1\0\27\4\1\0\3\4\1\0\1\4"+
    "\1\0\2\4\1\0\1\4\13\0\33\3\5\0\3\3\15\0\4\4"+
    "\14\0\6\4\13\0\32\3\5\0\13\3\16\4\7\0\12\4\4\0"+
    "\2\3\1\4\143\3\1\0\1\3\10\4\1\0\6\4\2\3\2\4"+
    "\1\0\4\4\2\3\12\4\3\3\2\0\1\3\17\0\1\4\1\3"+
    "\1\4\36\3\33\4\2\0\3\3\60\0\46\3\13\4\1\3\u014f\0"+
    "\3\4\66\3\2\0\1\4\1\3\20\4\2\0\1\3\4\4\3\0"+
    "\12\3\2\4\2\0\12\4\21\0\3\4\1\0\10\3\2\0\2\3"+
    "\2\0\26\3\1\0\7\3\1\0\1\3\3\0\4\3\2\0\1\4"+
    "\1\3\7\4\2\0\2\4\2\0\3\4\11\0\1\4\4\0\2\3"+
    "\1\0\3\3\2\4\2\0\12\4\4\3\15\0\3\4\1\0\6\3"+
    "\4\0\2\3\2\0\26\3\1\0\7\3\1\0\2\3\1\0\2\3"+
    "\1\0\2\3\2\0\1\4\1\0\5\4\4\0\2\4\2\0\3\4"+
    "\13\0\4\3\1\0\1\3\7\0\14\4\3\3\14\0\3\4\1\0"+
    "\11\3\1\0\3\3\1\0\26\3\1\0\7\3\1\0\2\3\1\0"+
    "\5\3\2\0\1\4\1\3\10\4\1\0\3\4\1\0\3\4\2\0"+
    "\1\3\17\0\2\3\2\4\2\0\12\4\1\0\1\3\17\0\3\4"+
    "\1\0\10\3\2\0\2\3\2\0\26\3\1\0\7\3\1\0\2\3"+
    "\1\0\5\3\2\0\1\4\1\3\6\4\3\0\2\4\2\0\3\4"+
    "\10\0\2\4\4\0\2\3\1\0\3\3\4\0\12\4\1\0\1\3"+
    "\20\0\1\4\1\3\1\0\6\3\3\0\3\3\1\0\4\3\3\0"+
    "\2\3\1\0\1\3\1\0\2\3\3\0\2\3\3\0\3\3\3\0"+
    "\10\3\1\0\3\3\4\0\5\4\3\0\3\4\1\0\4\4\11\0"+
    "\1\4\17\0\11\4\11\0\1\3\7\0\3\4\1\0\10\3\1\0"+
    "\3\3\1\0\27\3\1\0\12\3\1\0\5\3\4\0\7\4\1\0"+
    "\3\4\1\0\4\4\7\0\2\4\11\0\2\3\4\0\12\4\22\0"+
    "\2\4\1\0\10\3\1\0\3\3\1\0\27\3\1\0\12\3\1\0"+
    "\5\3\2\0\1\4\1\3\7\4\1\0\3\4\1\0\4\4\7\0"+
    "\2\4\7\0\1\3\1\0\2\3\4\0\12\4\22\0\2\4\1\0"+
    "\10\3\1\0\3\3\1\0\27\3\1\0\20\3\4\0\6\4\2\0"+
    "\3\4\1\0\4\4\11\0\1\4\10\0\2\3\4\0\12\4\22\0"+
    "\2\4\1\0\22\3\3\0\30\3\1\0\11\3\1\0\1\3\2\0"+
    "\7\3\3\0\1\4\4\0\6\4\1\0\1\4\1\0\10\4\22\0"+
    "\2\4\15\0\60\3\1\4\2\3\7\4\4\0\10\3\10\4\1\0"+
    "\12\4\47\0\2\3\1\0\1\3\2\0\2\3\1\0\1\3\2\0"+
    "\1\3\6\0\4\3\1\0\7\3\1\0\3\3\1\0\1\3\1\0"+
    "\1\3\2\0\2\3\1\0\4\3\1\4\2\3\6\4\1\0\2\4"+
    "\1\3\2\0\5\3\1\0\1\3\1\0\6\4\2\0\12\4\2\0"+
    "\2\3\42\0\1\3\27\0\2\4\6\0\12\4\13\0\1\4\1\0"+
    "\1\4\1\0\1\4\4\0\2\4\10\3\1\0\42\3\6\0\24\4"+
    "\1\0\2\4\4\3\4\0\10\4\1\0\44\4\11\0\1\4\71\0"+
    "\42\3\1\0\5\3\1\0\2\3\1\0\7\4\3\0\4\4\6\0"+
    "\12\4\6\0\6\3\4\4\106\0\46\3\12\0\51\3\7\0\132\3"+
    "\5\0\104\3\5\0\122\3\6\0\7\3\1\0\77\3\1\0\1\3"+
    "\1\0\4\3\2\0\7\3\1\0\1\3\1\0\4\3\2\0\47\3"+
    "\1\0\1\3\1\0\4\3\2\0\37\3\1\0\1\3\1\0\4\3"+
    "\2\0\7\3\1\0\1\3\1\0\4\3\2\0\7\3\1\0\7\3"+
    "\1\0\27\3\1\0\37\3\1\0\1\3\1\0\4\3\2\0\7\3"+
    "\1\0\47\3\1\0\23\3\16\0\11\4\56\0\125\3\14\0\u026c\3"+
    "\2\0\10\3\12\0\32\3\5\0\113\3\3\0\3\3\17\0\15\3"+
    "\1\0\4\3\3\4\13\0\22\3\3\4\13\0\22\3\2\4\14\0"+
    "\15\3\1\0\3\3\1\0\2\4\14\0\64\3\40\4\3\0\1\3"+
    "\3\0\2\3\1\4\2\0\12\4\41\0\3\4\2\0\12\4\6\0"+
    "\130\3\10\0\51\3\1\4\126\0\35\3\3\0\14\4\4\0\14\4"+
    "\12\0\12\4\36\3\2\0\5\3\u038b\0\154\3\224\0\234\3\4\0"+
    "\132\3\6\0\26\3\2\0\6\3\2\0\46\3\2\0\6\3\2\0"+
    "\10\3\1\0\1\3\1\0\1\3\1\0\1\3\1\0\37\3\2\0"+
    "\65\3\1\0\7\3\1\0\1\3\3\0\3\3\1\0\7\3\3\0"+
    "\4\3\2\0\6\3\4\0\15\3\5\0\3\3\1\0\7\3\17\0"+
    "\4\4\32\0\5\4\20\0\2\3\23\0\1\3\13\0\4\4\6\0"+
    "\6\4\1\0\1\3\15\0\1\3\40\0\22\3\36\0\15\4\4\0"+
    "\1\4\3\0\6\4\27\0\1\3\4\0\1\3\2\0\12\3\1\0"+
    "\1\3\3\0\5\3\6\0\1\3\1\0\1\3\1\0\1\3\1\0"+
    "\4\3\1\0\3\3\1\0\7\3\3\0\3\3\5\0\5\3\26\0"+
    "\44\3\u0e81\0\3\3\31\0\11\3\6\4\1\0\5\3\2\0\5\3"+
    "\4\0\126\3\2\0\2\4\2\0\3\3\1\0\137\3\5\0\50\3"+
    "\4\0\136\3\21\0\30\3\70\0\20\3\u0200\0\u19b6\3\112\0\u51a6\3"+
    "\132\0\u048d\3\u0773\0\u2ba4\3\u215c\0\u012e\3\2\0\73\3\225\0\7\3"+
    "\14\0\5\3\5\0\1\3\1\4\12\3\1\0\15\3\1\0\5\3"+
    "\1\0\1\3\1\0\2\3\1\0\2\3\1\0\154\3\41\0\u016b\3"+
    "\22\0\100\3\2\0\66\3\50\0\15\3\3\0\20\4\20\0\4\4"+
    "\17\0\2\3\30\0\3\3\31\0\1\3\6\0\5\3\1\0\207\3"+
    "\2\0\1\4\4\0\1\3\13\0\12\4\7\0\32\3\4\0\1\3"+
    "\1\0\32\3\12\0\132\3\3\0\6\3\2\0\6\3\2\0\6\3"+
    "\2\0\3\3\3\0\2\3\3\0\2\3\22\0\3\4\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\1\1\4\16\3"+
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\30\3\1\0\1\21"+
    "\16\3\1\22\2\3\1\23\10\3\1\24\1\0\1\25"+
    "\3\3\1\26\3\3\1\27\4\3\1\30\1\31\12\3"+
    "\1\32\1\21\3\3\1\33\1\34\1\35\3\3\1\36"+
    "\1\37\1\40\10\3\1\41\2\3\1\42\1\43\4\3"+
    "\1\44\2\3\1\45\1\46\1\47\10\3\1\50\5\3"+
    "\1\51\1\52\4\3\1\53\1\54\1\55\1\3\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[175];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2"+
    "\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398\0\56\0\56\0\56"+
    "\0\56\0\56\0\56\0\56\0\56\0\56\0\56\0\u03c6"+
    "\0\u03f4\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\u0508\0\u0536"+
    "\0\u0564\0\u0592\0\u05c0\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6"+
    "\0\u06d4\0\u0702\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816"+
    "\0\u0844\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986"+
    "\0\u09b4\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6"+
    "\0\u0b24\0\u0b52\0\270\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a\0\u0c38"+
    "\0\u0c66\0\u0c94\0\u0cc2\0\u0cf0\0\u0d1e\0\u0d4c\0\56\0\u0d7a"+
    "\0\270\0\u0da8\0\u0dd6\0\u0e04\0\270\0\u0e32\0\u0e60\0\u0e8e"+
    "\0\270\0\u0ebc\0\u0eea\0\u0f18\0\u0f46\0\270\0\270\0\u0f74"+
    "\0\u0fa2\0\u0fd0\0\u0ffe\0\u102c\0\u105a\0\u1088\0\u10b6\0\u10e4"+
    "\0\u1112\0\270\0\56\0\u1140\0\u116e\0\u119c\0\270\0\270"+
    "\0\270\0\u11ca\0\u11f8\0\u1226\0\270\0\270\0\270\0\u1254"+
    "\0\u1282\0\u12b0\0\u12de\0\u130c\0\u133a\0\u1368\0\u1396\0\270"+
    "\0\u13c4\0\u13f2\0\270\0\270\0\u1420\0\u144e\0\u147c\0\u14aa"+
    "\0\270\0\u14d8\0\u1506\0\270\0\270\0\270\0\u1534\0\u1562"+
    "\0\u1590\0\u15be\0\u15ec\0\u161a\0\u1648\0\u1676\0\270\0\u16a4"+
    "\0\u16d2\0\u1700\0\u172e\0\u175c\0\270\0\270\0\u178a\0\u17b8"+
    "\0\u17e6\0\u1814\0\270\0\270\0\270\0\u1842\0\270";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[175];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\2\1\3"+
    "\1\7\1\10\2\5\1\11\1\12\1\5\1\13\1\14"+
    "\1\15\1\16\1\5\1\17\1\5\1\20\3\5\1\21"+
    "\1\5\1\22\1\23\2\5\1\24\1\5\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\57\0\1\3\5\0\1\3\51\0\1\5"+
    "\5\0\32\5\16\0\2\5\4\0\32\5\20\0\1\41"+
    "\1\42\47\0\7\7\1\0\46\7\3\0\2\5\4\0"+
    "\1\5\1\43\20\5\1\44\7\5\16\0\2\5\4\0"+
    "\12\5\1\45\3\5\1\46\13\5\16\0\2\5\4\0"+
    "\5\5\1\47\1\50\23\5\16\0\2\5\4\0\11\5"+
    "\1\51\20\5\16\0\2\5\4\0\1\52\2\5\1\53"+
    "\16\5\1\54\7\5\16\0\2\5\4\0\11\5\1\55"+
    "\6\5\1\56\11\5\16\0\2\5\4\0\2\5\1\57"+
    "\27\5\16\0\2\5\4\0\6\5\1\60\2\5\1\61"+
    "\20\5\16\0\2\5\4\0\16\5\1\62\2\5\1\63"+
    "\5\5\1\64\2\5\16\0\2\5\4\0\11\5\1\65"+
    "\3\5\1\66\14\5\16\0\2\5\4\0\11\5\1\67"+
    "\20\5\16\0\2\5\4\0\10\5\1\70\21\5\16\0"+
    "\2\5\4\0\11\5\1\71\20\5\16\0\2\5\4\0"+
    "\11\5\1\72\20\5\70\0\1\73\7\41\1\0\46\41"+
    "\6\74\1\0\47\74\3\0\2\5\4\0\2\5\1\75"+
    "\27\5\16\0\2\5\4\0\1\5\1\76\30\5\16\0"+
    "\2\5\4\0\1\77\12\5\1\100\16\5\16\0\2\5"+
    "\4\0\2\5\1\101\27\5\16\0\2\5\4\0\6\5"+
    "\1\102\23\5\16\0\2\5\4\0\11\5\1\103\20\5"+
    "\16\0\2\5\4\0\13\5\1\104\2\5\1\105\13\5"+
    "\16\0\2\5\4\0\1\5\1\106\30\5\16\0\2\5"+
    "\4\0\17\5\1\107\12\5\16\0\2\5\4\0\11\5"+
    "\1\110\20\5\16\0\2\5\4\0\11\5\1\111\20\5"+
    "\16\0\2\5\4\0\1\112\31\5\16\0\2\5\4\0"+
    "\1\113\31\5\16\0\2\5\4\0\5\5\1\114\24\5"+
    "\16\0\2\5\4\0\16\5\1\115\13\5\16\0\2\5"+
    "\4\0\1\116\31\5\16\0\2\5\4\0\3\5\1\117"+
    "\26\5\16\0\2\5\4\0\14\5\1\120\15\5\16\0"+
    "\2\5\4\0\2\5\1\121\27\5\16\0\2\5\4\0"+
    "\13\5\1\122\16\5\16\0\2\5\4\0\13\5\1\123"+
    "\16\5\16\0\2\5\4\0\25\5\1\124\4\5\16\0"+
    "\2\5\4\0\21\5\1\125\10\5\16\0\2\5\4\0"+
    "\15\5\1\126\14\5\70\0\1\127\6\74\1\130\47\74"+
    "\3\0\2\5\4\0\3\5\1\131\26\5\16\0\2\5"+
    "\4\0\11\5\1\132\20\5\16\0\2\5\4\0\3\5"+
    "\1\133\26\5\16\0\2\5\4\0\3\5\1\134\26\5"+
    "\16\0\2\5\4\0\27\5\1\135\2\5\16\0\2\5"+
    "\4\0\7\5\1\136\22\5\16\0\2\5\4\0\5\5"+
    "\1\137\24\5\16\0\2\5\4\0\5\5\1\140\24\5"+
    "\16\0\2\5\4\0\26\5\1\141\3\5\16\0\2\5"+
    "\4\0\2\5\1\142\12\5\1\143\14\5\16\0\2\5"+
    "\4\0\2\5\1\144\27\5\16\0\2\5\4\0\1\5"+
    "\1\145\30\5\16\0\2\5\4\0\6\5\1\146\23\5"+
    "\16\0\2\5\4\0\3\5\1\147\26\5\16\0\2\5"+
    "\4\0\7\5\1\150\22\5\16\0\2\5\4\0\7\5"+
    "\1\151\22\5\16\0\2\5\4\0\3\5\1\152\26\5"+
    "\16\0\2\5\4\0\27\5\1\153\2\5\16\0\2\5"+
    "\4\0\6\5\1\154\23\5\16\0\2\5\4\0\10\5"+
    "\1\155\21\5\16\0\2\5\4\0\1\156\31\5\16\0"+
    "\2\5\4\0\5\5\1\157\24\5\16\0\2\5\4\0"+
    "\3\5\1\160\26\5\16\0\2\5\4\0\2\5\1\161"+
    "\27\5\16\0\2\5\4\0\21\5\1\162\10\5\13\0"+
    "\5\74\1\163\1\130\47\74\3\0\2\5\4\0\30\5"+
    "\1\164\1\5\16\0\2\5\4\0\16\5\1\165\13\5"+
    "\16\0\2\5\4\0\14\5\1\166\15\5\16\0\2\5"+
    "\4\0\3\5\1\167\26\5\16\0\2\5\4\0\1\170"+
    "\31\5\16\0\2\5\4\0\6\5\1\171\23\5\16\0"+
    "\2\5\4\0\13\5\1\172\16\5\16\0\2\5\4\0"+
    "\16\5\1\173\13\5\16\0\2\5\4\0\3\5\1\174"+
    "\26\5\16\0\2\5\4\0\1\175\31\5\16\0\2\5"+
    "\4\0\7\5\1\176\22\5\16\0\2\5\4\0\1\177"+
    "\31\5\16\0\2\5\4\0\1\5\1\200\30\5\16\0"+
    "\2\5\4\0\14\5\1\201\15\5\16\0\2\5\4\0"+
    "\3\5\1\202\26\5\16\0\2\5\4\0\6\5\1\203"+
    "\23\5\16\0\2\5\4\0\15\5\1\204\14\5\16\0"+
    "\2\5\4\0\6\5\1\205\23\5\16\0\2\5\4\0"+
    "\13\5\1\206\16\5\16\0\2\5\4\0\6\5\1\207"+
    "\23\5\16\0\2\5\4\0\7\5\1\210\22\5\16\0"+
    "\2\5\4\0\21\5\1\211\10\5\16\0\2\5\4\0"+
    "\1\212\31\5\16\0\2\5\4\0\1\213\31\5\16\0"+
    "\2\5\4\0\26\5\1\214\3\5\16\0\2\5\4\0"+
    "\16\5\1\215\13\5\16\0\2\5\4\0\4\5\1\216"+
    "\25\5\16\0\2\5\4\0\11\5\1\217\20\5\16\0"+
    "\2\5\4\0\27\5\1\220\2\5\16\0\2\5\4\0"+
    "\3\5\1\221\26\5\16\0\2\5\4\0\11\5\1\222"+
    "\20\5\16\0\2\5\4\0\24\5\1\223\5\5\16\0"+
    "\2\5\4\0\1\224\31\5\16\0\2\5\4\0\3\5"+
    "\1\225\26\5\16\0\2\5\4\0\7\5\1\226\22\5"+
    "\16\0\2\5\4\0\15\5\1\227\14\5\16\0\2\5"+
    "\4\0\13\5\1\230\16\5\16\0\2\5\4\0\5\5"+
    "\1\231\24\5\16\0\2\5\4\0\1\232\31\5\16\0"+
    "\2\5\4\0\3\5\1\233\26\5\16\0\2\5\4\0"+
    "\16\5\1\234\13\5\16\0\2\5\4\0\10\5\1\235"+
    "\21\5\16\0\2\5\4\0\11\5\1\236\20\5\16\0"+
    "\2\5\4\0\3\5\1\237\26\5\16\0\2\5\4\0"+
    "\13\5\1\240\16\5\16\0\2\5\4\0\3\5\1\241"+
    "\26\5\16\0\2\5\4\0\16\5\1\242\13\5\16\0"+
    "\2\5\4\0\5\5\1\243\24\5\16\0\2\5\4\0"+
    "\25\5\1\244\4\5\16\0\2\5\4\0\16\5\1\245"+
    "\13\5\16\0\2\5\4\0\3\5\1\246\26\5\16\0"+
    "\2\5\4\0\16\5\1\247\13\5\16\0\2\5\4\0"+
    "\1\250\31\5\16\0\2\5\4\0\1\5\1\251\30\5"+
    "\16\0\2\5\4\0\3\5\1\252\26\5\16\0\2\5"+
    "\4\0\1\253\31\5\16\0\2\5\4\0\7\5\1\254"+
    "\22\5\16\0\2\5\4\0\20\5\1\255\11\5\16\0"+
    "\2\5\4\0\13\5\1\256\16\5\16\0\2\5\4\0"+
    "\1\257\31\5\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6256];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\12\11\33\1\1\0\33\1\1\11"+
    "\1\0\32\1\1\11\74\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[175];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _IceLexer(){
    this((java.io.Reader)null);
  }

  public void goTo(int offset) {
    zzCurrentPos = zzMarkedPos = zzStartRead = offset;
    zzPushbackPos = 0;
    zzAtEOF = offset < zzEndRead;
  }


  _IceLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _IceLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1758) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 18: 
          { return SliceTokenTypes.KEYWORD_OUT;
          }
        case 47: break;
        case 4: 
          { return SliceTokenTypes.MACROS_LINE;
          }
        case 48: break;
        case 46: 
          { return SliceTokenTypes.KEYWORD_LOCALOBJECT;
          }
        case 49: break;
        case 11: 
          { return SliceTokenTypes.LBRACKET;
          }
        case 50: break;
        case 16: 
          { return SliceTokenTypes.END_OF_LINE_COMMENT;
          }
        case 51: break;
        case 22: 
          { return SliceTokenTypes.KEYWORD_ENUM;
          }
        case 52: break;
        case 25: 
          { return SliceTokenTypes.KEYWORD_BYTE;
          }
        case 53: break;
        case 9: 
          { return SliceTokenTypes.LBRACE;
          }
        case 54: break;
        case 26: 
          { return SliceTokenTypes.KEYWORD_VOID;
          }
        case 55: break;
        case 6: 
          { return SliceTokenTypes.GT;
          }
        case 56: break;
        case 30: 
          { return SliceTokenTypes.KEYWORD_SHORT;
          }
        case 57: break;
        case 10: 
          { return SliceTokenTypes.RBRACE;
          }
        case 58: break;
        case 42: 
          { return SliceTokenTypes.KEYWORD_INTERFACE;
          }
        case 59: break;
        case 45: 
          { return SliceTokenTypes.KEYWORD_DICTIONARY;
          }
        case 60: break;
        case 40: 
          { return SliceTokenTypes.KEYWORD_SEQUENCE;
          }
        case 61: break;
        case 21: 
          { return SliceTokenTypes.KEYWORD_TRUE;
          }
        case 62: break;
        case 1: 
          { return SliceTokenTypes.BAD_CHARACTER;
          }
        case 63: break;
        case 39: 
          { return SliceTokenTypes.KEYWORD_EXTENDS;
          }
        case 64: break;
        case 31: 
          { return SliceTokenTypes.KEYWORD_CLASS;
          }
        case 65: break;
        case 34: 
          { return SliceTokenTypes.KEYWORD_STRUCT;
          }
        case 66: break;
        case 8: 
          { return SliceTokenTypes.RPARENTH;
          }
        case 67: break;
        case 29: 
          { return SliceTokenTypes.KEYWORD_LOCAL;
          }
        case 68: break;
        case 24: 
          { return SliceTokenTypes.KEYWORD_BOOL;
          }
        case 69: break;
        case 23: 
          { return SliceTokenTypes.KEYWORD_LONG;
          }
        case 70: break;
        case 19: 
          { return SliceTokenTypes.KEYWORD_INT;
          }
        case 71: break;
        case 3: 
          { return SliceTokenTypes.IDENTIFIER;
          }
        case 72: break;
        case 35: 
          { return SliceTokenTypes.KEYWORD_STRING;
          }
        case 73: break;
        case 28: 
          { return SliceTokenTypes.KEYWORD_FLOAT;
          }
        case 74: break;
        case 38: 
          { return SliceTokenTypes.KEYWORD_MODULE;
          }
        case 75: break;
        case 41: 
          { return SliceTokenTypes.KEYWORD_EXCEPTION;
          }
        case 76: break;
        case 14: 
          { return SliceTokenTypes.COMMA;
          }
        case 77: break;
        case 32: 
          { return SliceTokenTypes.KEYWORD_CONST;
          }
        case 78: break;
        case 2: 
          { return SliceTokenTypes.WHITE_SPACE;
          }
        case 79: break;
        case 20: 
          { return SliceTokenTypes.ELLIPSIS;
          }
        case 80: break;
        case 5: 
          { return SliceTokenTypes.LT;
          }
        case 81: break;
        case 12: 
          { return SliceTokenTypes.RBRACKET;
          }
        case 82: break;
        case 44: 
          { return SliceTokenTypes.KEYWORD_IMPLEMENTS;
          }
        case 83: break;
        case 37: 
          { return SliceTokenTypes.KEYWORD_OBJECT;
          }
        case 84: break;
        case 33: 
          { return SliceTokenTypes.KEYWORD_THROWS;
          }
        case 85: break;
        case 13: 
          { return SliceTokenTypes.SEMICOLON;
          }
        case 86: break;
        case 43: 
          { return SliceTokenTypes.KEYWORD_IDEMPOTENT;
          }
        case 87: break;
        case 7: 
          { return SliceTokenTypes.LPARENTH;
          }
        case 88: break;
        case 17: 
          { return SliceTokenTypes.C_STYLE_COMMENT;
          }
        case 89: break;
        case 15: 
          { return SliceTokenTypes.DOT;
          }
        case 90: break;
        case 36: 
          { return SliceTokenTypes.KEYWORD_DOUBLE;
          }
        case 91: break;
        case 27: 
          { return SliceTokenTypes.KEYWORD_FALSE;
          }
        case 92: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
