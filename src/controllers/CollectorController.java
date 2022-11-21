/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 * *Refaktorálja: Bognár Dávid
 * *2022.11.21.
 */

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;

public class CollectorController extends MainController {
   
    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);

        mainWindow.startButton.addActionListener(event -> {

            String route = mainWindow.urlField.getText();
            if (route.isEmpty()) {
                route = "https://index.hu";
            }

            Page page = new Page();
            page.setUrl(route);

            ArrayList<String> words = page.getContent();

            for(String word : words) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setmessage("Szavak: " + wordCount.toString());
        });
    }   
}
