package com.qjkobe.work;

public class main {
  public static void main(String[] args) {
    AdvancedSearchFieldEnum userrole = new AdvancedSearchFieldEnum();
    AdvancedSearchParameter param = new AdvancedSearchParameter();
    param.setKey("USER_ROLE");
    param.setValues(new String[]{"H"});;

    for (int i = 0; i < userrole.getUpSqlWhere().length; i++) {
      String sqlWhere = AdvancedSearchUtil.getParameterValuesSQLList(false, i, param, userrole, null, "S");
      System.out.println(sqlWhere);
    }
  }
}
