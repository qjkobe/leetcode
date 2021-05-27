package com.qjkobe;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ReadExcel {
  private HSSFSheet sheet;

  /**
   * 构造函数，初始化excel数据
   * @param filePath  excel路径
   * @param sheetName sheet表名
   */
  ReadExcel(String filePath,String sheetName){
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream(filePath);
      HSSFWorkbook sheets = new HSSFWorkbook(fileInputStream);
      //获取sheet
      sheet = sheets.getSheet(sheetName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 根据行和列的索引获取单元格的数据
   * @param row
   * @param column
   * @return
   */
  public String getExcelDateByIndex(int row,int column){
    HSSFRow row1 = sheet.getRow(row);
    String cell = row1.getCell(column).toString();
    return cell;
  }

  /**
   * 根据某一列值为“******”的这一行，来获取该行第x列的值
   * @param caseName
   * @param currentColumn 当前单元格列的索引
   * @param targetColumn 目标单元格列的索引
   * @return
   */
  public String getCellByCaseName(String caseName,int currentColumn,int targetColumn){
    String operateSteps="";
    //获取行数
    int rows = sheet.getPhysicalNumberOfRows();
    for(int i=0;i<rows;i++){
      HSSFRow row = sheet.getRow(i);
      String cell = row.getCell(currentColumn).toString();
      if(cell.equals(caseName)){
        operateSteps = row.getCell(targetColumn).toString();
        break;
      }
    }
    return operateSteps;
  }

  //打印excel数据
  public void readExcelData(){
    //获取行数
    int rows = sheet.getPhysicalNumberOfRows();
    for(int i=0;i<rows;i++){
      //获取列数
      HSSFRow row = sheet.getRow(i);
      int columns = row.getPhysicalNumberOfCells();
      for(int j=0;j<columns;j++){
        String cell = row.getCell(j).toString();
        System.out.println(cell);
      }
    }
  }

  private Set<String> getExternalClass(String expectExternalModule) {
    Set<String> set = new HashSet<>();
    int startRowNum = sheet.getFirstRowNum();
    int endRowNum = sheet.getLastRowNum();
    System.out.printf("start row: %s, end row: %s %n", startRowNum, endRowNum);
    int externalModuleColumnNum = 'J' - 'A';
    int externalClassColumnNum = 'K' - 'A';
    for (int i = startRowNum; i < endRowNum; i++) {
      HSSFRow row1 = sheet.getRow(i);
      String externalModule = row1.getCell(externalModuleColumnNum).toString();
      if (expectExternalModule.equals(externalModule)) {
        set.add(row1.getCell(externalClassColumnNum).toString());
      }
    }
    return set;
  }

  //测试方法
  public static void main(String[] args){
    ReadExcel sheet1 = new ReadExcel("/Users/i501206/Documents/JavaTrain/src/com/qjkobe/resource/au-personsearch-dependencies.xls", "au-personsearch-dependencies-cl");
    //从0开始算下标
    String cell2 = sheet1.getExcelDateByIndex(1, 'J'-'A');
    Set<String> externalClass = sheet1.getExternalClass("au-employeeprofilepoc-service");
    externalClass.forEach(System.out::println);
  }
}
