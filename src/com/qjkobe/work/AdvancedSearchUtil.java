package com.qjkobe.work;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class AdvancedSearchUtil {
  protected static String getParameterValuesSQLList(boolean isEC, int index, AdvancedSearchParameter param,
                                                    AdvancedSearchFieldEnum rqField, List vals, String matchType) {
    SqlWhereClauseHelperEnum condition = SqlWhereClauseHelperEnum.NOCONDITION;
    SqlAdvancedSearchParameterTypeEnum type = SqlAdvancedSearchParameterTypeEnum.DONT_USE;
    String[] matchValue = new String[]{"A", "M", "E", "H"};
    String[] values = null;
    String sqlWhere = rqField.getUpSqlWhere()[index];

    // matchType :
    // "S" – Starts with
    // "E" – Exact match
    if (matchValue != null) {
      values = param.getValues();
    } else {
      if (type.equals(SqlAdvancedSearchParameterTypeEnum.USE_VALUES) || type
        .equals(SqlAdvancedSearchParameterTypeEnum.USE_BOTH)) {
        values = param.getValues();
      } else if (type.equals(SqlAdvancedSearchParameterTypeEnum.USE_IDS)) {
        values = param.getIds();
      }
    }

    if (values == null || values.length == 0) {
      return null;
    } else {

      for (int i = 0; i < values.length; i++) {
        values[i] = values[i].toLowerCase();
      }

      if (matchValue != null) {
        if (Arrays.asList(values).contains(matchValue[index].toLowerCase())) {
          return sqlWhere;
        } else {
          return null;
        }
      } else if (values.length == 1) {
        if (condition.equals(SqlWhereClauseHelperEnum.EQUAL) || condition.equals(SqlWhereClauseHelperEnum.IN)) {
          vals.add(values[0]);
          return sqlWhere + " = ?";
        } else if (condition.equals(SqlWhereClauseHelperEnum.LIKE)) {

          if (matchType == null || "E".equals(matchType)) {
            vals.add(values[0]);
            return sqlWhere + " = ?";
          } else {
            vals.add(values[0] + "%");
            return sqlWhere + " like ?";
          }
        }
      } else {
        if (condition.equals(SqlWhereClauseHelperEnum.EQUAL) || condition.equals(SqlWhereClauseHelperEnum.IN)) {
          String sqlInListValue =
            sqlWhere + " in (" + AdvancedSearchCommonUtil.getsSqlParameterQuestionMarksString(values.length, ", ") +
              ")";
          vals.addAll(Arrays.asList(values));
          return sqlInListValue;
        } else if (condition.equals(SqlWhereClauseHelperEnum.LIKE)) {
          if (matchType == null || "E".equals(matchType)) {
            String sqlInListValue =
              sqlWhere + " in (" + AdvancedSearchCommonUtil.getsSqlParameterQuestionMarksString(values.length, ", ") +
                ")";
            vals.addAll(Arrays.asList(values));
            return sqlInListValue;
          } else {
            for (int i = 0; i < values.length; i++) {
              values[i] = values[i] + "%";
            }
            vals.addAll(Arrays.asList(values));
            return "( " + sqlWhere + " like " +
              AdvancedSearchCommonUtil.getsSqlParameterQuestionMarksString(values.length,
                " or " + sqlWhere + " like ") + ")";
          }
        }
      }
    }
    return null;

  }
}
