package com.qjkobe.ETMail;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class SendEmail {
  private static Robot robot;

  public static void input(Robot robot, String s) {
    if (s.charAt(0) != 'i' && s.charAt(0) != 'I') {
      return;
    }
    robot.delay(300);
    robot.keyPress(KeyEvent.VK_I);
    robot.keyRelease(KeyEvent.VK_I);
    int num;
    for (int i = 1; i < 7; i++) {
      switch (s.charAt(i)) {
        case '0':
          robot.keyPress(KeyEvent.VK_0);
          robot.keyRelease(KeyEvent.VK_0);
          break;
        case '1':
          robot.keyPress(KeyEvent.VK_1);
          robot.keyRelease(KeyEvent.VK_1);
          break;
        case '2':
          robot.keyPress(KeyEvent.VK_2);
          robot.keyRelease(KeyEvent.VK_2);
          break;
        case '3':
          robot.keyPress(KeyEvent.VK_3);
          robot.keyRelease(KeyEvent.VK_3);
          break;
        case '4':
          robot.keyPress(KeyEvent.VK_4);
          robot.keyRelease(KeyEvent.VK_4);
          break;
        case '5':
          robot.keyPress(KeyEvent.VK_5);
          robot.keyRelease(KeyEvent.VK_5);
          break;
        case '6':
          robot.keyPress(KeyEvent.VK_6);
          robot.keyRelease(KeyEvent.VK_6);
          break;
        case '7':
          robot.keyPress(KeyEvent.VK_7);
          robot.keyRelease(KeyEvent.VK_7);
          break;
        case '8':
          robot.keyPress(KeyEvent.VK_8);
          robot.keyRelease(KeyEvent.VK_8);
          break;
        case '9':
          robot.keyPress(KeyEvent.VK_9);
          robot.keyRelease(KeyEvent.VK_9);
          break;
      }
    }
  }

  private static String mailStr = "Zhao, Evan <evan.zhao@sap.com>; Wang, Scarlett <scarlett.wang@sap.com>; Chen, Dylan <dylan.chen@sap.com>; Liu, Vivian <vivian.liu05@sap.com>; Ye, Yanan <yanan.ye@sap.com>; Cheng, Xi <xi.cheng@sap.com>; Xu, Echo <echo.xu01@sap.com>; Li, Huanyu <huanyu.li01@sap.com>; Zhang, James <james.zhang01@sap.com>; Pang, Moon <moon.pang@sap.com>; Niu, Hongye <hongye.niu@sap.com>; Wang, Helen <helen.wang01@sap.com>; Zhou, Sage <sage.zhou@sap.com>; Xie, Wanying <wanying.xie@sap.com>; Zhang, Boris <boris.zhang@sap.com>; Lu, Leo <leo.lu@sap.com>; Yang, Jenny <jenny.yang05@sap.com>; Zhang, Kathy <kathy.zhang01@sap.com>; Jia, Vera <v.jia@sap.com>; Wu, June <june.wu@sap.com>; Jin, Kris <kris.jin@sap.com>; Jin, Kris <kris.jin@sap.com>; Dong, Sunny <sunny.dong@sap.com>; Wang, Evan <evan.wang02@sap.com>; Qiao, Gary <gary.qiao@sap.com>; Cai, Cherry <cherry.cai@sap.com>; Xu, Ricardo <ricardo.xu@sap.com>; Zhou, Joseph <joseph.zhou@sap.com>; Liao, Allie <allie.liao@sap.com>; Wang, Keane <keane.wang@sap.com>; Wan, June <june.wan@sap.com>; Han, Esther <esther.han@sap.com>; Zhao, Amy <amy.zhao02@sap.com>; Hu, Chauncy <chauncy.hu@sap.com>; Ji, Joyce <joyce.ji@sap.com>; Zhou, Bob <bob.zhou@sap.com>; Wu, Lionel <lionel.wu@sap.com>; Xu, Ricardo <ricardo.xu@sap.com>; Zhang, Wing <wing.zhang@sap.com>; Zhou, Bob <bob.zhou@sap.com>; Wu, Lionel <lionel.wu@sap.com>; Peng, Jianqing <jianqing.peng@sap.com>; Shen, Cindy <cindy.shen01@sap.com>; Zhong, Eileen <eileen.zhong@sap.com>; Zhou, Ying <ying.zhou01@sap.com>; Yang, Jenny <jenny.yang05@sap.com>; Yu, Ivy <ivy.yu@sap.com>; Zhang, Kathy <kathy.zhang01@sap.com>; Jia, Vera <v.jia@sap.com>; Zhang, Wing <wing.zhang@sap.com>; Wu, June <june.wu@sap.com>; Wu, June <june.wu@sap.com>; Wu, June <june.wu@sap.com>; Lu, Leo <leo.lu@sap.com>; Zhang, Bing <bing.zhang02@sap.com>; Zhou, Ying <ying.zhou01@sap.com>; Lu, Leo <leo.lu@sap.com>; Peng, Jianqing <jianqing.peng@sap.com>; Wu, June <june.wu@sap.com>; Dong, Liyan <liyan.dong01@sap.com>; Wang, Doris <doris.wang02@sap.com>; Zhai, Jessica <jessica.zhai@sap.com>; Wei, Wendy <wendy.wei01@sap.com>; Wei, Wendy <wendy.wei01@sap.com>; Liu, Jenny <jenny.liu01@sap.com>; Wang, Daniel <daniel.wang08@sap.com>; Li, Peihua <peihua.li@sap.com>; Zhou, Bob <bob.zhou@sap.com>; Wang, Krystal <krystal.wang@sap.com>; Yan, Rosie <rosie.yan@sap.com>; Huang, He <he.huang01@sap.com>; Qin, Henry <henry.qin@sap.com>; Ji, Emily <emily.ji@sap.com>; Liu, Haley <haley.liu@sap.com>; Wang, Kaka <kaka.wang@sap.com>; Wang, Daniel <daniel.wang08@sap.com>; Li, Jenny <jenny.li01@sap.com>; Xu, Perry <perry.xu@sap.com>; Shi, Feng <feng.shi@sap.com>; Liu, Georges <george.liu01@sap.com>; Han, Amy <amy.han@sap.com>; Fan, Amber <amber.fan@sap.com>; Yu, Raining <raining.yu@sap.com>; Li, Max <max.li02@sap.com>; Zhang, Sherry <sherry.zhang02@sap.com>; Tian, Zongquan <z.tian@sap.com>; Qiao, Gary <gary.qiao@sap.com>; Chang, Roy <roy.chang@sap.com>; Jin, Echo <echo.jin@sap.com>; Burkhart, Nathan <nathan.burkhart@sap.com>; Wang, Frank <frank.wang02@sap.com>; Xu, Coco <coco.xu03@sap.com>; Dong, Liyan <liyan.dong01@sap.com>; Guo, Gavin <gavin.guo@sap.com>; Lin, Herman <herman.lin@sap.com>; Wu, Cindy <cindy.wu02@sap.com>; Qu, Grace <grace.qu@sap.com>; Gao, Alex <alex.gao01@sap.com>; Yin, Haley <haley.yin@sap.com>; Wang, Dora <dora.wang01@sap.com>; Bao, Patrick <patrick.bao@sap.com>; Li, Fan <fan.li01@sap.com>; Zhan, Sindy <sindy.zhan@sap.com>; Liu, Yueyao <yueyao.liu@sap.com>; Zhang, Frank <frank.zhang10@sap.com>; Li, Theresa <theresa.li@sap.com>; Zhang, Jiajia <jiajia.zhang@sap.com>; Shi, Emily <emily.shi@sap.com>; Chen, Sabrina <sabrina.chen@sap.com>; Chu, Iris <i.chu@sap.com>; Ren, Tina <tina.ren@sap.com>; Wang, Tian <tian.wang@sap.com>; Chen, Tao <tao02.chen@sap.com>; Chen, Jenna <jenna.chen@sap.com>; Zhou, Kai <kai.zhou02@sap.com>; Tao, Crystal <crystal.tao@sap.com>; Li, Vivian <vivian.li@sap.com>; Liu, Anne <anne.liu@sap.com>; Li, Wen <wen01.li@sap.com>; Zhu, Tina <tina.zhu01@sap.com>; Gu, Farrah <farrah.gu@sap.com>; Cheng, Lisa <lisa.cheng01@sap.com>; Li, Lucy <lucy01.li@sap.com>; Xu, Yvette <yvette.xu@sap.com>; Huang, Alice <alice.huang@sap.com>; He, Yi <yi.he01@sap.com>; Wu, Tina <tina.wu01@sap.com>; Xu, Lei <lei.xu02@sap.com>; Cai, Carol <carol.cai@sap.com>; Li, Wendy <wendy.li02@sap.com>; Tao, Crystal <crystal.tao@sap.com>; Xie, Eric <eric.xie@sap.com>; Liu, Kiki <kiki.liu@sap.com>; Zhao, Vivi <vivi.zhao@sap.com>; Liu, Kiki <kiki.liu@sap.com>; Fan, Michael <michael.fan02@sap.com>; Zhang, Crystal <crystal.zhang@sap.com>; Wang, Kelly <kelly.wang@sap.com>; Zhang, Tao <tao.zhang01@sap.com>; Xia, Jason <jason.xia@sap.com>; Chen, Payne <payne.chen@sap.com>; Zhu, Jude <jude.zhu@sap.com>; Liang, Jalyn <jalyn.liang@sap.com>; Hu, Christy <christy.hu@sap.com>; Shao, Derek <derek.shao@sap.com>; Zhang, Yue <yue.zhang10@sap.com>; Tang, Qin <qin.tang@sap.com>; Zhang, Ning <ni.zhang@sap.com>; Zhu, Winson <winson.zhu@sap.com>; Chen, Catherine <catherine.chen@sap.com>; Chen, Catherine <catherine.chen@sap.com>; Jin, Emily <emily.jin@sap.com>; Zhang, Xuewei <xuewei.zhang@sap.com>; Shao, Yuying <yuying.shao01@sap.com>; Shen, Rocky <rocky.shen@sap.com>; Gao, Luke <luke.gao@sap.com>; Hui, Jian-ping <jian-ping.hui@sap.com>; Kang, Xiangfei <xiangfei.kang@sap.com>; Chen, Doreen <doreen.chen@sap.com>; Chen, Doreen <doreen.chen@sap.com>Chen, Doreen <doreen.chen@sap.com>; Hu, Siwen <s.hu@sap.com>; Chen, Edward <edward.chen01@sap.com>; Zheng, Jays <jays.zheng@sap.com>; Ren, Sunny <sunny.ren@sap.com>; Li, Amber <amber.li01@sap.com>; Gao, Lingling <lingling.gao@sap.com>; Chen, Even <even.chen@sap.com>; Xiong, Bobby <bobby.xiong@sap.com>; Chen, Adam <adam.chen@sap.com>; Lu, Bill <bill.lu01@sap.com>; Yan, Rosie <rosie.yan@sap.com>; Tan, Andy <and.tan@sap.com>; Ji, Alice <alice.ji@sap.com>; Ji, Alice <alice.ji@sap.com>; Lv, Fu-qiang <fu-qiang.lv@sap.com>; Bi, Conan <conan.bi@sap.com>; Wu, Julia <julia.wu@sap.com>; Xie, Frank <frank.xie@sap.com>; Wang, Yang <yang.wang09@sap.com>; Zhang, Jenna <jenna.zhang@sap.com>; Bao, Allen <allen.bao@sap.com>";
  private static Set<String> mailSet = new HashSet<>();
  public static String getMail(String name){
    String[] mailList = mailStr.split(";");
    for (String s : mailList) {
      mailSet.add(s.trim());
    }
    String[] fullName = name.split(" ");
    String realName = fullName[1] + ", " + fullName[0];
    for (String s : mailSet) {
      if (s.contains(realName)) {
        return s;
      }
    }
    return "";
  }

  public static void main(String[] args) {
    String sList[] = {"I501206-SH.png", "Event Deadline: 18:00 Nov 25th.txt", "I324422 - BJ.png", "I531573 Dalian.PNG", "I346352-DL.jpg", "I327008-SH.png", "I349412_Dalian.png", "I504236_Shanghai.JPG", "I533803_XA.png", "i312236_XA.jpg", "I500041_DaLian.png", "I070515_Dalian.png", "i538248_XA.png", "I065895_Dalian.PNG", "I330809 – Beijing-CN.png", "I308062_Dalian.png", "I325873_Shanghai.PNG", "I336475 - Shanghai.png", "I030440_Dalian.jpg", "I303519_shanghai.png", "I007238-SH.png", "I076187_SH.jpg", "D071651-Shanghai.png", "I519095_Shanghai.png", "I335545_Beijing.png", "I058780 – Dalian.png", "I523918_Shanghai.png", "I532781.png", "I062913-BJ.jpg", "I075260_Shanghai.PNG", "I306528_Dalian.png", "I329817_SH.png", "I530781_SH.png", "I312275_XA.png", "I059552_Dalian.PNG", "I524970_SH.png", "I505925 Shanghai.PNG", "I531520-Shanghai.PNG", "i513642_CD.png", "I537420-Shanghai.png", "I523118-SH.JPG", "I075337_SH.PNG", "i063048 - Beijing.png", "I532101_shanghai.png", "i075929-Nanjing.png", "i302783_xian.png", "I355000-SH.png", "I537174_SHA.png", "I007238-Shanghai.png", "I349262-SH.png", "I355373_DL.png", "I310226_Beijing.png", "I335579_Shanghai.png", "I329821-Beijing.png", "I531706-Shanghai.png", "I345719-Beijing.png", "I312275_XA_2.png", "I322436_BJ.png", "I517894_SH.png", "I008187_CHENGDU.png", "I329717 - Beijing.png", "I061355_DL.PNG", "I530240_DL.PNG", "I318972-chengdu.png", "I531706-Shanghai.png", "I310190_BJ.png", "I319461_Beijing.JPG", "I068859_DaLiang.png", "I305452 - DL.png", "20201124103916.png", "I518220-xian.png", "I334617-Shanghai.PNG", "I070860_DL.PNG", "I330967_Dalian.JPG", "I324546 SH.JPG", "I337186_Beijing.png", "I302783_XA.png", "I070859 – DL.png", "I513246-Shanghai.png", "I510335_Dalian.png", "I320014-Beijing.gif", "I523918-Shanghai.png", "I530356-Chengdu.png", "I349262-Shanghai.png", "I308077-Beijing.png", "I070470-Dalian.jpg", "I337296_Beijing.png", "I334766_Beijing.jpg", "I331933_Shanghai.png", "I339159_Beijing.SNAG", "I303516_Beijing.png", "I508520 - Dalian.png", "i512165 - SH.png", "I505432_Shanghai.png", "I539246_Beijing.png", "I533835-Shanghai.png", "I523159-Shanghai.PNG", "I070511_Dalian.PNG", "I350511-Shanghai.jpg", "I028645 Dalian.png", "I501355-SH.JPG", "I065956_Dalian.PNG", "I029186_Dalian.PNG", "I060266_Shanghai.PNG", "i532542_SH.png", "I532244_Shanghai.png", "Thank you.png", "I332396_SH.png", "I062326_BJG07.jpg", "I520041_ShanghaiLabs.png", "I062413 _Xi'an.jpg", "I509157_SH.png", "I329599-Shanghai.jpg", "I531986_xi'an.png", "I062378_BJG07.jpg", "I342073_SH.png", "I310459_Shanghai.PNG", "I074159 PVG01, D4.61.PNG", "I303655_Shanghai.PNG", "i320915 SHA.png", "I060552_SHA.png", "I530415-Dalian.PNG", "I332396-SH.png", "I532801_CTU02.png", "I015122-Shanghai.png", "I054401_Shanghai.PNG", "I015122_Shanghai.PNG", "I340423_SH_Michael_Fan.jpg", "I062248_BJ.png", "I059431_DL.png", "i311783_SH.png", "I043417-Chengdu.jpg", "I073376-Shanghai.jpg", "i515227-shanghai.png", "i054842-shanghai.png", "i353558_chengdu.JPG", "I336731_DaLian.PNG", "I503969 - Dalian.PNG", "I519533_SH.png", "I071093_SH.jpg", "I075415_Shanghai.png", "I348164 - SH.png", "I071977_Dalian.JPG", "I349427-Dalian.png", "I537642 Dalian.png", "I301114ShanghaiLabs.png", "I505745 Dalian.png", "I062693 Xi'an.jpg", "i074360 Beijing.jpg", "I028435_Shanghai.PNG", "I028435_Shanghai.PNG", "I069934 Chengdu.png", "I065859_SH_Chartime.png", "I324255-Shanghai-Chartime.jpg", "I355504_Dalian.JPG", "I524712 Dalian.png", "i322609_shanghai.png", "I353670 Chengdu.png", "I061003_Dalian.PNG", "I317543_Beijing.png", "I508224_SHLabs.png", "I517894_ShangHai.PNG", "i062893_Shanghai.png", "I077395_Beijing.png", "I074309-Xian.png", "i517234-SH.png", "I340541_SH.JPG", "I506216_ChengDu.png", "I333951-Dalian.PNG", "I306551_Dalian.PNG", "I335322 -Dalian.jpg", "I508511-Dalian.PNG", "I059159_Dalian.PNG"};
    String nameList[] = {"Kris Jin","Kris Jin","Bing Zhang","Evan Zhao","Scarlett Wang","Dylan Chen","Vivian Liu","Yanan Ye","Xi Cheng","Echo Xu","Huanyu Li","James Zhang","Moon Pang","Marissa Ren","Hongye Niu","Helen Wang","Sage Zhou","Wanying Xie","Boris Zhang","Leo Lu","June Wu","Wing Zhang","Xilin Li","Vera Jia","Kathy Zhang","Ivy Yu","David Chen","Jenny Yang","Ying Zhou","Eileen Zhong","Cindy Shen","Jianqing Peng","Lionel Wu","Bob Zhou","Joyce Ji","Chauncy Hu","Amy Zhao","Esther Han","June Wan","Keane Wang","Allie Liao","Suki Huang","Joseph Zhou","Ricardo Xu","Cherry Cai","Gary Qiao","Evan Wang","Sunny Dong","June Wu","Liyan Dong","Doris Wang","Jessica Zhai","Wendy Wei","Jenny Liu","Daniel Wang","Peihua Li","Bob Zhou","Krystal Wang","Rosie Yan","He Huang","Henry Qin","Emily Ji","Haley Liu","Kaka Wang","Daniel Wang","Jenny Li","Perry Xu","Feng Shi","Georges Liu","Tiemin Wang","Amy Han","Amber Fan","Raining Yu","Max Li","Sherry Zhang","Zongquan Tian","Gary Qiao","Roy Chang","Echo Jin","Fiona Zou","Frank Wang","Frank Zhang","Coco Xu","Liyan Dong","Gavin Guo","Herman Lin","Cindy Wu","Grace Qu","Alex Gao","Haley Yin","Dora Wang","Patrick Bao","Fan Li","Sindy Zhan","Yueyao Liu","Frank Zhang","Theresa Li","Jiajia Zhang","Emily Shi","Sabrina Chen","Iris Chu","Tina Ren","Tian Wang","Tao Chen","Jenna Chen","Kai Zhou","Faming Qu","Crystal Tao","Vivian Li","Anne Liu","Wen Li","Tina Zhu","Farrah Gu","Lisa Cheng","Lucy Li","Yvette Xu","Alice Huang","David Duan","Tina Wu","Lei Xu","Carol Cai","Wendy Li","Crystal Tao","Eric Xie","Kiki Liu","Vivi Zhao","Jacky Ding","Michael Fan","Crystal Zhang","Kelly Wang","Tao Zhang","Jason Xia","Payne Chen","Jude Zhu","Jalyn Liang","Christy Hu","Derek Shao","Yue Zhang","Qin Tang","Ning Zhang","Winson Zhu","Catherine Chen","Emily Jin","Xuewei Zhang","Yuying Shao","Rocky Shen","Luke Gao","Cindy Qi","Cindy Qi","Doreen Chen","Doreen Chen","Siwen Hu","Edward Chen","Jays Zheng","Sunny Ren","Amber Li","Lingling Gao","Even Chen","Bobby Xiong","Adam Chen","Bill Lu","Rosie Yan","Andy Tan","Alice Ji","Fu-qiang Lv","Conan Bi","Julia Wu","Frank Xie","Yang Wang","Jenna Zhang","Allen Bao", "Nick Wang", "Zhu Wang"};
    int i = 0;
//    HashSet<String> top100 = new HashSet<>();
    Map<String, String> top100 = new HashMap<>();
    Map<String, String> end88 = new HashMap<>();

//    HashSet<String> end88 = new HashSet<>();

    int index = -1;
    for(String s : sList){
      index++;
      String iNumber = s.substring(0,7);
      if (s.charAt(0) != 'i' && s.charAt(0) != 'I') {
        continue;
      }
      if(top100.containsKey(iNumber)){
        continue;
      }
      i++;
      String location = "";
      if(s.length()>11) {
        location = s.substring(8, s.length() - 4);
      }else {
        location = "";
      }
      if (i <= 100) {
        top100.put(iNumber, nameList[index] + "\t" + location + "\t" + getMail(nameList[index]));
      } else {
        end88.put(iNumber, nameList[index] + "\t" + location + "\t" + getMail(nameList[index]));
      }
    }

    String fileName = "/Users/i501206/Documents/nameListOfExpress.txt";

    List<String> remoteMailList = new ArrayList<>();
    //read file into stream, try-with-resources
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

      stream.forEach(remoteMailList::add);

    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String s : remoteMailList) {
      if("Hui, Jian-ping <jian-ping.hui@sap.com>".equals(s)){
        System.out.println("手账");
      }
      if("Wang, Zhu <zhu.wang01@sap.com>".equals(s)){
        System.out.println("手账");
      }
//      System.out.println(s);
      int finish = 0;
      for (Map.Entry<String, String> entry : top100.entrySet()) {
        if (entry.getValue().contains(s) && finish == 0) {
//          System.out.println(s+"\t"+"香薰"+entry.getValue());
          System.out.println("香薰");
          finish = 1;
        }else if(finish ==1){
          break;
        }
        else {
          for (Map.Entry<String, String> entry2 : end88.entrySet()) {
            if (entry2.getValue().contains(s) && finish == 0) {
//              System.out.println(s+"\t"+"手账"+entry2.getValue());
              System.out.println("手账");
              finish = 1;
            }
          }
        }
      }
    }
    System.out.println(remoteMailList.size());
    for (Map.Entry<String, String> entry : end88.entrySet()) {
      if (entry.getValue().contains("Cindy Qi")) {
        System.out.println(entry.getKey()+entry.getValue());
        System.out.println("1111");
      }
    }
    System.out.println(top100.size());
    System.out.println(end88.size());
    System.out.println("------------------------");
//    for (Map.Entry entry : top100.entrySet()) {
//      System.out.println(entry.getKey() + "\t" + entry.getValue());
//    }
//
//
//    System.out.println("----------------");
//    for (Map.Entry entry : end88.entrySet()) {
//      System.out.println(entry.getKey() + "\t" + entry.getValue());
//    }

//    try {
//      robot = new Robot();
//    } catch (Exception e) {
//
//    }
//    robot.mouseMove(-30, 143);
//    robot.delay(300);
//    robot.mousePress(KeyEvent.BUTTON1_MASK);
//    robot.mouseRelease(KeyEvent.BUTTON1_MASK);
//    System.out.println(sList[48]);
//    System.out.println(sList.length);
//    for (int i = 163; i < sList.length; i++) {
//      System.out.println("index: " + i);
//      input(robot, sList[i]);
//      robot.delay(500);
//      robot.mouseMove(-1767, 223);
//      robot.delay(300);
//      robot.mousePress(KeyEvent.BUTTON1_MASK);
//      robot.mouseRelease(KeyEvent.BUTTON1_MASK);
//      robot.delay(2000);
//      robot.mousePress(KeyEvent.BUTTON1_MASK);
//      robot.mouseRelease(KeyEvent.BUTTON1_MASK);
//      robot.delay(300);
//
//      robot.mouseMove(-30, 143);
//      robot.delay(300);
//      robot.mousePress(KeyEvent.BUTTON1_MASK);
//      robot.mouseRelease(KeyEvent.BUTTON1_MASK);
//      robot.delay(300);
//    }

  }
}
