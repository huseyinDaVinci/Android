package com.barin.mdmappliation.application;

import com.barin.mdmappliation.application.util.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barin on 4/26/2016.
 */

public final class FakeParameterCreater {

  static List<String> notificationParameters = new ArrayList<>();
  static List<String> pushParameters = new ArrayList<>();
  static List<String> pullParameters = new ArrayList<>();

  static String testHostName;
  static String testUserName;
  static String testServerPath;

  public static void initiliaze() {

    if (Constants.LOCAL_TEST) {
      testHostName = "10.0.3.2";
      testUserName = "tester";
      testServerPath = "/tabletmdm/";
    } else {
      testHostName = "10.85.97.23";
      testUserName = "tbllog";
      testServerPath = "/export/home/tbllog/tabletmdm/";
    }
  }

/* pull-sunucu
  /export/home/tbllog/tabletmdm/%%test3.txt%%/TeknosaFiles/databases/%%pamukkale_test3.txt%%tbllog%%10.85.97.23
  /export/home/tbllog/tabletmdm/%%test2.txt%%/TeknosaFiles/databases/%%pamukkale_test2.txt%%tbllog%%10.85.97.23
  /export/home/tbllog/tabletmdm/%%tabletHardwareInfo%%/TeknosaFiles/%%pamukkale_tabletHardware%%tbllog%%10.85.97.23

  pull-local_sunucu

  /tabletmdm/%%test3.txt%%/TeknosaFiles/databases/%%rebex_tabletHardware%%tester%%10.0.3.2
      /tabletmdm/%%test2.txt%%/TeknosaFiles/databases/%%rebex_tabletHardware%%tester%%10.0.3.2
      /tabletmdm/%%tabletHardwareInfo%%/TeknosaFiles/%%rebex_tabletHardware%%tester%%10.0.3.2

  push
  /TeknosaFiles/%%configE.json%%/export/home/tbllog/tabletmdm/%%tablet_configE.json%%tbllog%%10.85.97.23
  /TeknosaFiles/databases/%%logs.db%%/export/home/tbllog/tabletmdm/%%tablet_logs.db%%tbllog%%10.85.97.23

  push-
  local sunucu
  /TeknosaFiles/%%configE.json%%/tabletmdm/%%tablet_configE.json%%tester%%10.0.3.2
  /TeknosaFiles/databases/%%logs.db%%/tabletmdm/%%tablet_logs.db%%tester%%10.0.3.2


  notification
  biggie smalls
  %%juicy tupac%%changes*/

  public static List<String> getPullParameters(HowProper howProper) {
    pullParameters.clear();

    switch (howProper) {
      case PROPER:
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test3.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_test3.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tabletHardwareInfo"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_tabletHardwareInfo"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test2.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_test2.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);

        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test.apk"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_test.apk"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        break;

      case NOT_PROPER:

        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "wrong_file.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_wrong_file.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tabletHardwareInfo"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/wrong_path/"
            + Constants.COMMAND_SEPARATOR
            + "server_tabletHardwareInfo"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "wrong_file.txt"
            + Constants.COMMAND_SEPARATOR
            + "wrong_path"
            + Constants.COMMAND_SEPARATOR
            + "server_wrong_file.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);

        break;

      case MIX:

        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test3.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "test3.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "wrong_file.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "serrver_wrong_file.txt"

            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);
        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test2.txt"
            + Constants.COMMAND_SEPARATOR
            + "/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "server_test2.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);

        pullParameters.add(testServerPath
            + Constants.COMMAND_SEPARATOR
            + "test2.txt"
            + Constants.COMMAND_SEPARATOR
            + "/wrong_path/"
            + Constants.COMMAND_SEPARATOR
            + "server_test2.txt"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            + testHostName);

        break;

      default:

        throw new RuntimeException("cannot be happen body..");
    }

    return pullParameters;
  }

  public static List<String> getPushParameters(HowProper howProper) {
    pushParameters.clear();

    switch (howProper) {
      case PROPER:
        pushParameters.add("/TeknosaFiles/"
            + Constants.COMMAND_SEPARATOR
            + "configE.json"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_configE.json"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);
/*
        pushParameters.add("/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "logs.db"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_logs.db"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);*/
        break;
      case NOT_PROPER:

        pushParameters.add("/TeknosaFiles/"
            + Constants.COMMAND_SEPARATOR
            + "wrong.json"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_wrong.json"
            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);

        pushParameters.add("/wrongpath/databases/"
            + Constants.COMMAND_SEPARATOR
            + "logs.db"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_logs.db"

            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);
        break;
      case MIX:

        pushParameters.add("/TeknosaFiles/"
            + Constants.COMMAND_SEPARATOR
            + "configE.json"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_configE.json"

            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);

        pushParameters.add("/TeknosaFiles/databases/"
            + Constants.COMMAND_SEPARATOR
            + "wrong.db"
            + Constants.COMMAND_SEPARATOR
            + testServerPath
            + Constants.COMMAND_SEPARATOR
            + "tablet_wrong.db"

            + Constants.COMMAND_SEPARATOR
            + testUserName
            + Constants.COMMAND_SEPARATOR
            +
            testHostName);
        break;

      default:
        throw new RuntimeException("cannot be happen!!");
    }

    return pushParameters;
  }

  public static List<String> getNotificationParameters(HowProper howProper) {
    notificationParameters.clear();
    switch (howProper) {

      case PROPER:
        notificationParameters.add("testTitle%%We are champions");
        notificationParameters.add("testTitle%%I feel divosion");
        notificationParameters.add("testTitle%%we the real!!!");
        notificationParameters.add("testTitle%%Aventura");
        break;
      case NOT_PROPER:
        notificationParameters.add("testTitle%%????SDAFsafkajdfl....,,,,????");
        notificationParameters.add("testTitle%%46546456adsfadksjfldkaf???**********");

        break;
      case MIX:
        notificationParameters.add("testTitle%%????SDAFsafkajdfl....,,,,????");
        notificationParameters.add("testTitle%%46546456adsfadksjfldkaf???**********");
        notificationParameters.add("testTitle%%Aventura");
        break;
      default:
        throw new RuntimeException("cannot be happen!!");
    }

    return notificationParameters;
  }

  public static void corruptServerSettings() {
    testHostName = "www.testitbody.com";
    testUserName = "hopdedikaynan";
  }
}
