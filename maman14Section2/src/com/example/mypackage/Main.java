package com.example.mypackage;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean quit = false;

        Object[] options = {"QUITE", "ADD", "DELETE", "UPDATE", "SHOW", "SEARCH", "IMPORT"};
        Dictionary dictionary = new Dictionary();

        while (!quit) {

            int dictionaryMain = JOptionPane.showOptionDialog(null,
                    "Available actions:\n\n" +
                            "0 - To quit the system\n" +
                            "1 - To add term and meaning\n" +
                            "2 - To remove term and meaning\n" +
                            "3 - To update meaning of the therm\n" +
                            "4 - To illustrate sort list of the Dictionary\n" +
                            "5 - To search term in our dictionary \n" +
                            "6 - Import from file the term you want to show  \n",
                    "Click your choice", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            String key = " ";
            String value = " ";
            String resulte = "";

            switch (dictionaryMain) {

                case 0:
                    System.out.println("QUITE");
                    System.out.println("Thank you about your time : ) ");
                    quit = true;
                    break;
                case 1:
                    System.out.println("ADD");

                    key = JOptionPane.showInputDialog(null,
                            "Please enter your key",
                            "your key - >",
                            JOptionPane.PLAIN_MESSAGE);

                    // if clicked ok show input dialog for value
                    value = JOptionPane.showInputDialog(null,
                            "Please enter your value",
                            "your value",
                            JOptionPane.PLAIN_MESSAGE);
                    // if clicked ok you have the two strings variables than you can call to
                    // key and value are assigned
                    // dictionary var with insert function.
                    dictionary.insert(key, value);
                    //System.out.println(dictionary.getDictionary());//{ghrftg=gdfdgf}
                    resulte = dictionary.illustrateSortList();//ghrftg - gdfdgf
                    if (!resulte.isEmpty()) {
                        System.out.println(resulte);
                        quit = false;
                    } else {
                        System.out.println("Invalid Input.");
                    }
                    break;
                case 2:
                    System.out.println("DELETE");

                    key = JOptionPane.showInputDialog(null,
                            "Please enter your key that you want delete",
                            "your key - >",
                            JOptionPane.PLAIN_MESSAGE);

                    boolean isDelet = dictionary.removeTerm(key);
                    if (isDelet) {
                        resulte = dictionary.illustrateSortList();//ghrftg - gdfdgf
                        if (!resulte.isEmpty()) {
                            System.out.println(" the " + key + " is found and remove from our tree map ");
                            System.out.println(resulte);
                            quit = false;
                        } else {
                            System.out.println("Invalid Input.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("UPDATE");

                    key = JOptionPane.showInputDialog(null,
                            "Please enter your new key that you want to update",
                            "your key - >",
                            JOptionPane.PLAIN_MESSAGE);

                    value = JOptionPane.showInputDialog(null,
                            "Please enter your new value",
                            "your value",
                            JOptionPane.PLAIN_MESSAGE);

                    boolean isUpdate = dictionary.updateValueByKey(key, value);
                    resulte = dictionary.illustrateSortList();//ghrftg - gdfdgf
                    if (!resulte.isEmpty()) {
                        if (isUpdate) {
                            System.out.println("your update is complete");
                            System.out.println(resulte + "\n");
                            quit = false;
                        }
                    } else {
                        System.out.println("Invalid Input.");
                    }
                    break;
                case 4:
                    System.out.println("SHOW\n");
                    resulte = dictionary.illustrateSortList();//ghrftg - gdfdgf
                    if (!resulte.isEmpty()) {
                        System.out.println("To illustrate sort list of the Dictionary");
                        System.out.println(resulte + "\n");
                        quit = false;
                    }
                    break;
                case 5:
                    System.out.println("SEARCH\n");

                    key = JOptionPane.showInputDialog(null,
                            "Please enter your key to look for",
                            "your key - >",
                            JOptionPane.PLAIN_MESSAGE);

                    resulte = dictionary.searchByKey(key);
                    if (!resulte.isEmpty()) {
                        System.out.println("the item that you search: " + resulte + "\n");
                        quit = false;
                    } else {
                        System.out.println(resulte);
                    }
                    break;
                case 6:
                    System.out.println("IMPORT");

                    JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue1 = jfc1.showOpenDialog(null);
                    if (returnValue1 == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jfc1.getSelectedFile();
                        File file = new File(selectedFile.getAbsolutePath());
                        FileReader reader = new FileReader(selectedFile.getAbsolutePath());
                        char[] chars = new char[(int) file.length()];
                        reader.read(chars);//read chearcter
                        String fileContent = "";

                        for (Character c : chars) {
                            fileContent =fileContent + c;
                        }

                        String[] eachLineSplit = fileContent.split( "\n");

                        for ( String row: eachLineSplit ) {
                            String[] contentOfEachLine = row.split("-");
                            dictionary.insert(contentOfEachLine[0],contentOfEachLine[1]);
                        }

                        resulte = dictionary.illustrateSortList();
                        if (!resulte.isEmpty()) {
                            System.out.println(resulte);
                            quit = false;
                        } else {
                            System.out.println("Invalid Input.");
                        }
                    }
                    break;
            }
        }

    }

}



