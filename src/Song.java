import com.sun.xml.internal.fastinfoset.util.StringArray;
import exception.InvalidNoteException;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.Buffer;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.sound.midi.*;
/*
 * Created by JFormDesigner on Sat Oct 14 12:13:47 MDT 2017
 */


/**
 * @author Huy Khoa Le
 */
public class Song extends JFrame
{

    private int songIndex;

    public Song()
    {
        initComponents();
        displayGUI();
    }


    private void displayGUI()
    {
        this.setVisible(true);
        this.setTitle("Song GUI");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void songComboBoxActionPerformed(ActionEvent e)
    {
        // TODO add your code here

        JComboBox comboBox = (JComboBox) e.getSource();
        this.songIndex = comboBox.getSelectedIndex();
    }

    private void playSongButtonActionPerformed(ActionEvent e)
    {
        // TODO add your code here

        if (songIndex == 0) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/closertotheheart.txt")));

                String line = null;
                Note note;
                
                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");
                    
                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }
                            
                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }
                    
                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (songIndex == 1) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/fatlip.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        if (songIndex == 2) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/morethanafeeling.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        if (songIndex == 3) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/paintitblack.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        if (songIndex == 4) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/song1.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (songIndex == 5) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/song2.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (songIndex == 6) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/song3.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (songIndex == 7) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/song4.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (songIndex == 8) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/song5.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (songIndex == 9) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/sweetchildofmine.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (songIndex == 10) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("res/testsong.txt")));

                String line = null;
                Note note;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] noteListFromFirstLine = line.split(",");

                    for(int i = 0; i <noteListFromFirstLine.length; i++)
                    {
                        try {

                            Pattern p = Pattern.compile("[abcdefgABCDEFG]{1}#?\\d?#?");
                            Matcher m = p.matcher(noteListFromFirstLine[i]);
                            if (m.find()) {
                                String noteCleanedAndErrorChecked = m.group();  // The matched substring

                                note = new Note(noteCleanedAndErrorChecked);
                                playNote(note.getMIDIAbsoluteNumber());
                            }

                        } catch (InvalidNoteException e1) {
                            e1.printStackTrace();
                        }
                    }

                }


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void playNote(int note)
    {
        Synthesizer synthesizer = null;
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
        } catch (MidiUnavailableException mue) {
        }
        Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
        synthesizer.loadInstrument(instruments[30]);
        MidiChannel[] channels = synthesizer.getChannels();
        channels[1].noteOn(note, 127);
        //sets the instrument to play the note.
        channels[1].programChange(12);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ie) {
        }
        channels[1].noteOff(note, 127);
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        String[] songList = {"closer to the heart", "fat lip", "more than a  feeling", "paint it black",
                "song 1", "song 2", "song 3", "song 4", "song 5", "sweet child of mine", "test song"};

        label1 = new JLabel();
        songComboBox = new JComboBox(songList);
        songComboBox.setSelectedIndex(0);
        label2 = new JLabel();
        playSongButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Huy Le Song Player");

        //---- songComboBox ----
        songComboBox.addActionListener(e -> songComboBoxActionPerformed(e));

        //---- label2 ----
        label2.setText("Song:");

        //---- playSongButton ----
        playSongButton.setText("Play Song");
        playSongButton.addActionListener(e -> playSongButtonActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(239, 239, 239)
                                                .addComponent(label1))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(songComboBox, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(253, 253, 253)
                                                .addComponent(playSongButton)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(songComboBox))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playSongButton)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JComboBox songComboBox;
    private JLabel label2;
    private JButton playSongButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args)
    {
        Song song = new Song();
    }
}
