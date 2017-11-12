import exception.InvalidNoteException;
import org.junit.runner.manipulation.NoTestsRemainException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.sound.midi.*;
/*
 * Created by JFormDesigner on Sat Oct 14 00:07:17 MDT 2017
 */


/**
 * @author Huy Khoa Le
 */
public class Melody extends JFrame
{
    private static Melody melody;
    
    public Melody()
    {
        initComponents();
        displayGUI();
        buttonGroupForRadio();
    }

    private void displayGUI()
    {
        this.setVisible(true);
        this.setTitle("Melody GUI");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonGroupForRadio()
    {
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(radioFrequency);
        btnGrp.add(radioHalfStep);
        btnGrp.add(radioMusicNote);
    }

    private void button1ActionPerformed(ActionEvent e)
    {
        // TODO add your code here

        if (radioFrequency.isSelected()) 
        {
            String theirInput = noteTextField.getText().trim();
            
            double theirFrequency = Double.parseDouble(theirInput);

            try {
                Note note = new Note(theirFrequency);
                int k = note.getMIDIAbsoluteNumber();
                for(int i = 0; i < 12; i++)
                {
                    melody.playNote(k);
                    k++;
                }
                
            } catch (InvalidNoteException e1) {
                e1.printStackTrace();
            }


        } else if (radioHalfStep.isSelected()) 
        {
            String theirInput = noteTextField.getText().trim();
            
            int halfStep = Integer.parseInt(theirInput);

            try {
                Note note = new Note(halfStep);
                
                int k = note.getMIDIAbsoluteNumber();
                
                for (int i = 0; i < 12; i++)
                {
                    melody.playNote(k);
                    k++;
                }
                
            } catch (InvalidNoteException e1) {
                e1.printStackTrace();
            }


        } else if (radioMusicNote.isSelected()) 
        {
            String theirInput = noteTextField.getText().trim();

            try {
                Note note = new Note(theirInput);
                
                int k = note.getMIDIAbsoluteNumber();
                
                for(int i = 0; i <12 ; i++)
                {
                    melody.playNote(k);
                    k++;
                }
                
            } catch (InvalidNoteException e1) {
                e1.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Select One Of The Radio Buttons And Input The Note Value");
        }

    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        label2 = new JLabel();
        radioFrequency = new JRadioButton();
        radioHalfStep = new JRadioButton();
        radioMusicNote = new JRadioButton();
        noteTextField = new JTextField();
        label3 = new JLabel();
        playButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Huy Le Melody Player");

        //---- label2 ----
        label2.setText("Play Note From:");

        //---- radioFrequency ----
        radioFrequency.setText("Frequency");

        //---- radioHalfStep ----
        radioHalfStep.setText("Half Step");

        //---- radioMusicNote ----
        radioMusicNote.setText("Music Note");

        //---- label3 ----
        label3.setText("Note:");

        //---- playButton ----
        playButton.setText("Play");
        playButton.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(radioFrequency)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioHalfStep)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioMusicNote))
                                .addComponent(noteTextField))))
                    .addContainerGap(29, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 174, Short.MAX_VALUE)
                    .addComponent(playButton)
                    .addGap(172, 172, 172))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(radioFrequency)
                        .addComponent(radioHalfStep)
                        .addComponent(radioMusicNote))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(noteTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(playButton)
                    .addContainerGap(9, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JLabel label2;
    private JRadioButton radioFrequency;
    private JRadioButton radioHalfStep;
    private JRadioButton radioMusicNote;
    private JTextField noteTextField;
    private JLabel label3;
    private JButton playButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

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
            Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
        channels[1].noteOff(note, 127);
    }

    public static void main(String[] args)
    {
        melody = new Melody();
    }
}
