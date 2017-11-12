import exception.InvalidNoteException;
import org.junit.Before;
import org.junit.Test;
import sun.security.x509.DeltaCRLIndicatorExtension;

import static org.junit.Assert.*;



public class NoteTest
{

    @Test
    public void createNoteFromFrequency()
    {
        try {
            //exercise
            Note note = new Note(3520.0000000000);
            
            int actual = note.getMIDIAbsoluteNumber();
            
            //verify
            int expected = 105;
            assertEquals("testing to see the midi note value", expected, actual);
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getMidiNoteTest()
    {
        try {
            //exercise
            Note note = new Note(1174.6590716696);

            int actual = note.getMIDIAbsoluteNumber();

            //verify
            int expected = 86;
            assertEquals("testing to see the midi note value", expected, actual);


        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getFrequencyHzTest()
    {
        //exercise
        try {
            Note note = new Note(1174.6590716696);
            
            double actual = Math.round(note.getFrequencyInHz() - 0.5) + 0.5;
            
            //verify
            double expected = Math.round(1174.6590716696 - 0.5) + 0.5;
            assertEquals("testing getting the frequency in Hz", expected, actual, 0.00000000);
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void createNoteFromSemitones()
    {
        //exercise
        try {
            Note note = new Note(4);
            
            double actualFrequency = note.getFrequencyInHz();
            int actualMidi = note.getMIDIAbsoluteNumber();
            int a = 0;
            
            //verify
            double expectedFrequency = 554.3652619537442;
            int expectedMidiVal = 73;
            
            assertEquals("testing frequency from creating note by semi tone", expectedFrequency, actualFrequency, 0.0000);
            assertEquals("testing midi value from creating note by semi tone", expectedMidiVal, actualMidi, 0.0000);
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }


    }
    
    @Test
    public void getHalfStepTest()
    {
        try {
            Note note = new Note(554.3652619537);
            //exercise
            int halfStepActual = note.getHalfSteps(); 
            
            //verify
            int expected = 4;
            
            assertEquals("testing the getting half steps", expected, halfStepActual);
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void modifyNoteBySemitones()
    {
        //exercise

        try {
            Note note = new Note(440.0);
            
            note.modifyNoteBySemitones(4);
            
            double frequencyActual = note.getFrequencyInHz();
            
            int a = 0;
            
            //verify
            double frequencyExpected = 554.3652619537442;
            
            assertEquals("testing modifying note by semitones", frequencyExpected, frequencyActual, 0.00000000000);
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void formOctaveTest()
    {
        //exercise

        try {
            Note note = new Note(880.0000000000);
            
            Note note2 = new Note(440.0);
            
            boolean actual = note.formOctave(note2);
            
            //verify
            boolean expected = true;
            assertEquals("testing to see if note form octave aka 12 semi tones higher than the other ", expected, actual);
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }

    }
    
    @Test
    public void createNoteFromString()
    {
        //exercise

        try {
            
            Note note = new Note("F#7");
            
            int midiValActual = note.getMIDIAbsoluteNumber();
            double frequencyActual = note.getFrequencyInHz();
            
            
            //verify
            int expectedMidi = 102;
            double expectedFrequency = 2959.955381693075;

            assertEquals("testing midi value to seeing create note form String", expectedMidi, midiValActual, 0.00000);
            assertEquals("testing frequency to seeing create note form String", expectedFrequency, frequencyActual, 0.00000);
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void compareToTest()
    {
        //exercise
        try {
            Note note = new Note(440.0);
            Note note2 = new Note(440.0);
            
            int resultActual = note.compareTo(note2);
            
            //verify
            int expected = 0;
            
            assertEquals("testing compareTo to see if the 2 object equal", expected, resultActual);
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }

    }
    
    
}