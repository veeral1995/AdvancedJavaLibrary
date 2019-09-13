package com.library.view;

import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Dimension;

public class Utils {

    public static void centerWindow(Component comp) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension frameSize = comp.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    comp.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);
  }

   @SuppressWarnings("deprecation")
public static void showErrorMessage(Exception e) {
     //exception occurred, so do not process further and return now after showing message.
     Dialog msgDlg = new Dialog("Error",
                                              e.getMessage() != null ?
                                              e.getMessage() : "Error occurred");
     Utils.centerWindow(msgDlg);
     e.printStackTrace();
     msgDlg.setModal(true);
     msgDlg.show();

  }

}
