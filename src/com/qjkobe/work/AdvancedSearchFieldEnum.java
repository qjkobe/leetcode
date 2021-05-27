package com.qjkobe.work;

public class AdvancedSearchFieldEnum {
  public String[] getUpSqlWhere() {
    return new String[]{null,
      "u.USERS_SYS_DIRECTREPORTS > 0",
      "u.USERS_SYS_DIRECTREPORTS = 0",
      "((SELECT COUNT(1) FROM <db_schema>.USERS_SYSINFO us WHERE us.USERS_SYS_HRUID=u.users_sys_id) > 0)"};
  }
}
