package com.qjkobe.work;

import java.util.Arrays;

public class AdvancedSearchCommonUtil {
  public static String getsSqlParameterQuestionMarksString(int len, String separator) {
    String[] questionMarks = new String[len];
    Arrays.fill(questionMarks, "?");
    return join(questionMarks, separator);
  }

  public static String join(Object[] array, String separator) {
    return array == null ? null : join(array, separator, 0, array.length);
  }

  public static String join(Object[] array, String separator, int startIndex, int endIndex) {
    if (array == null) {
      return null;
    } else {
      if (separator == null) {
        separator = "";
      }

      int bufSize = endIndex - startIndex;
      if (bufSize <= 0) {
        return "";
      } else {
        bufSize *= (array[startIndex] == null ? 16 : array[startIndex].toString().length()) + separator.length();
        StringBuffer buf = new StringBuffer(bufSize);

        for(int i = startIndex; i < endIndex; ++i) {
          if (i > startIndex) {
            buf.append(separator);
          }

          if (array[i] != null) {
            buf.append(array[i]);
          }
        }

        return buf.toString();
      }
    }
  }
}
