package com.qjkobe.work;

import java.io.Serializable;

public class AdvancedSearchParameter {
  public static final long serialVersionUID = 1;

  private String _key;
  private String[] _ids;
  private String[] _values;

  public AdvancedSearchParameter() {
  }

  /**
   * Constructor
   */
  public AdvancedSearchParameter(String key, String[] ids, String[] values) {
    _key = key;
    _ids = ids;
    _values = values;
  }

  /**
   * Getter getKey() - get parameter field id
   *
   * @return String _key
   */
  public String getKey() {
    return _key;
  }

  /**
   * Getter getIds() - get parameter selected entity ids - if parameter is EC/other entity
   *
   * @return String[] _ids
   */
  public String[] getIds() {
    return _ids;
  }

  /**
   * Getter getValues() - get parameter selected entity names - for non-EC query
   *
   * @return String[] _values
   */
  public String[] getValues() {
    return _values;
  }

  /**
   * Setter setKey() - set parameter field id
   *
   * @param key
   */
  public void setKey(String key) {
    _key = key;
  }

  /**
   * Setter setIds() - set parameter selected entity ids - if parameter is EC/other entity
   *
   * @param ids
   */
  public void setIds(String[] ids) {
    _ids = ids;
  }

  /**
   * Setter getValues() - set parameter selected entity names - for non-EC query
   *
   * @param values
   */
  public void setValues(String[] values) {
    _values = values;
  }

//    /**
//     * toString()
//     */
//    public String toString() {
//      return this.getClass().getName() + ": <" + _key + (_ids!=null? ", ids:" + StringUtils.join(_ids, ",") : "") + (_values!=null ? ", values:" + StringUtils.join(_values, ",") : "")+">";
//    }
}
